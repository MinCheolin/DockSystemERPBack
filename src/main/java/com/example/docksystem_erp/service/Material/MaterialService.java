package com.example.docksystem_erp.service.Material;

import com.example.docksystem_erp.dto.Equipment.MESEquipmentDto;
import com.example.docksystem_erp.dto.Material.MESMaterialDto;
import com.example.docksystem_erp.dto.Material.MaterialCreateRequestDto;
import com.example.docksystem_erp.dto.Material.MaterialResponseDto;
import com.example.docksystem_erp.dto.Material.MaterialUpdateRequestDto;
import com.example.docksystem_erp.entity.Material.Material;
import com.example.docksystem_erp.repository.Material.MaterialRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MaterialService {

    private final MaterialRepository materialRepository;
    private final RestTemplate restTemplate;
    @Value("${mes.base-url}")
    private String mesApiUrl;
    @Autowired
    public MaterialService(MaterialRepository materialRepository,
                           RestTemplate restTemplate){
        this.materialRepository = materialRepository;
        this.restTemplate = restTemplate;
    }
    //새로운 자재 정보 생성
    public Material createMaterial(MaterialCreateRequestDto requestDto){
        Material material = new Material();
        material.setMaterialCode(requestDto.getMaterialCode());
        material.setMaterialName(requestDto.getMaterialName());
        material.setMaterialType(requestDto.getMaterialType());
        material.setMaterialSize(requestDto.getMaterialSize());
        material.setMaterialPrice(requestDto.getMaterialPrice());
        material.setMaterialUnit(requestDto.getMaterialUnit());

        Material newMaterial = materialRepository.save(material);
        MESMaterialDto dto = new MESMaterialDto();
        dto.setErpMaterialNo(newMaterial.getMaterialNo().toString());
        dto.setMaterialCode(newMaterial.getMaterialCode());
        dto.setMaterialName(newMaterial.getMaterialName());
        sendEquipmentMES(dto);

        return newMaterial;
    }

    //db상 모든 자재 정보 조회
    public List<MaterialResponseDto> getAllMaterial(){
        return materialRepository.findAll().stream()
                .map(MaterialResponseDto::fromEntity)
                .collect(Collectors.toList());
    }

    //삭제
    public void deleteMaterial(Long materialNo){

        if(!materialRepository.existsById(materialNo))
        {
            throw new EntityNotFoundException("해당 No의 자재를 찾을 수 없습니다."+materialNo);
        }
        materialRepository.deleteById(materialNo);

        restTemplate.delete(mesApiUrl+"/materialNo/"+materialNo);
    }

    //업데이트
    public Material updateMaterial(Long materialNo, MaterialUpdateRequestDto requestDto){
        Material existingMaterial = materialRepository.findById(materialNo)
                .orElseThrow(()->new EntityNotFoundException(("해당 No의 자재를 찾을 수 없습니다."+materialNo)));
        existingMaterial.updateMaterial(requestDto);

        Material updateMaterial = materialRepository.save(existingMaterial);

        MESMaterialDto dto = new MESMaterialDto();
        dto.setErpMaterialNo(updateMaterial.getMaterialNo().toString());
        dto.setMaterialCode(updateMaterial.getMaterialCode());
        dto.setMaterialName(updateMaterial.getMaterialName());
        sendEquipmentMES(dto);

        return existingMaterial;
    }

    //mes 전송
    public void sendEquipmentMES(MESMaterialDto dto){
        try{
            restTemplate.postForObject(mesApiUrl+"/materials",dto,String.class);
            System.out.println("전송 성공");
        }catch (Exception e){
            System.err.println("전송 실패");
            e.printStackTrace();
        }
    }
}
