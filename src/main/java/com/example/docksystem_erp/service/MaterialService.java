package com.example.docksystem_erp.service;

import com.example.docksystem_erp.dto.MaterialCreateRequestDto;
import com.example.docksystem_erp.dto.MaterialResponseDto;
import com.example.docksystem_erp.dto.MaterialUpdateRequestDto;
import com.example.docksystem_erp.entity.Material;
import com.example.docksystem_erp.repository.MaterialRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MaterialService {

    private final MaterialRepository materialRepository;
    @Autowired
    public MaterialService(MaterialRepository materialRepository){
        this.materialRepository = materialRepository;
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
        return materialRepository.save(material);
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
    }

    //업데이트
    public Material updateMaterial(Long materialNo, MaterialUpdateRequestDto requestDto){
        Material existingMaterial = materialRepository.findById(materialNo)
                .orElseThrow(()->new EntityNotFoundException(("해당 No의 자재를 찾을 수 없습니다."+materialNo)));
        existingMaterial.updateMaterial(requestDto);
        return existingMaterial;
    }
}
