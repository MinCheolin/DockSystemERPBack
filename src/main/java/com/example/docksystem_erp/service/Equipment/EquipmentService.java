package com.example.docksystem_erp.service.Equipment;

import com.example.docksystem_erp.dto.Equipment.*;
import com.example.docksystem_erp.entity.Equipment.Equipment;
import com.example.docksystem_erp.entity.Equipment.EquipmentType;
import com.example.docksystem_erp.repository.Equipment.EquipmentRepository;
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
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;
    private final RestTemplate restTemplate;
    @Value("${mes.base-url}")
    private String mesApiUrl;

    @Autowired
    public EquipmentService(EquipmentRepository equipmentRepository,
                            RestTemplate restTemplate){
        this.equipmentRepository = equipmentRepository;
        this.restTemplate = restTemplate;
    }
    //새로운 장비 정보 생성
    public Equipment createEquipment(EquipmentCreateRequestDto requestDto){
        Equipment equipment = new Equipment();
        equipment.setEquipCode(requestDto.getEquipCode());
        equipment.setEquipName(requestDto.getEquipName());
        equipment.setType(requestDto.getType());
        equipment.setEquipPrice(requestDto.getEquipPrice());
        equipment.setEquipDepreciation(requestDto.getEquipDepreciation());
        equipment.setEquipPurchaseDate(requestDto.getEquipPurchaseDate());
        equipment.setEquipLastInspected(requestDto.getEquipLastInspected());

        Equipment newEquipment = equipmentRepository.save(equipment);

        ToMESEquipmentDto dto = new ToMESEquipmentDto();
        dto.setErpEquipNo(newEquipment.getEquipNo().toString());
        dto.setEquipCode(newEquipment.getEquipCode());
        dto.setEquipName(newEquipment.getEquipName());
        sendEquipmentMES(dto);

        return newEquipment;
    }

    //db상 모든 창고 정보 조회
    public List<EquipmentResponseDto> getAllEquipment(){
        return equipmentRepository.findAll().stream()
                .map(EquipmentResponseDto::fromEntity)
                .collect(Collectors.toList());
    }

    //삭제
    public void deleteEquipment(Long equipNo){
        Equipment existingEquipment = equipmentRepository.findById(equipNo)
                .orElseThrow(()->new EntityNotFoundException("해당 No의 장비를 찾을 수 없습니다."+equipNo));

        equipmentRepository.delete(existingEquipment);
        //mes로 delete 요청

        restTemplate.delete(mesApiUrl + "/equipments/" + equipNo);
    }

    public Equipment updateFromMes(FromMesEquipmentDto dto){
        Equipment existingEquipment = equipmentRepository.findById(dto.getEquipNo())
                .orElseThrow(()->new EntityNotFoundException("해당 No의 장비를 찾을 수 없습니다."));

        if(!dto.getType().equals(existingEquipment.getType())){
            existingEquipment.setType(dto.getType());
            equipmentRepository.save(existingEquipment);
        }

        return existingEquipment;
    }

    //업데이트
    public Equipment updateEquipment(Long equipNo, EquipmentUpdateRequestDto requestDto){
        Equipment existingEquipment = equipmentRepository.findById(equipNo)
                .orElseThrow(()->new EntityNotFoundException("해당 No의 장비를 찾을 수 없습니다."+equipNo));
        existingEquipment.updateEquipment(requestDto);

        Equipment updateEquipment = equipmentRepository.save((existingEquipment));

       ToMESEquipmentDto dto = new ToMESEquipmentDto();
        dto.setErpEquipNo(updateEquipment.getEquipNo().toString());
        dto.setEquipCode(updateEquipment.getEquipCode());
        dto.setEquipName(updateEquipment.getEquipName());
        sendEquipmentMES(dto);

        return existingEquipment;
    }

    //mes 전송
    public void sendEquipmentMES(ToMESEquipmentDto dto){
        try{
            restTemplate.postForObject(mesApiUrl+"/equipments",dto,String.class);
            System.out.println("전송 성공");
        }catch (Exception e){
            System.err.println("전송 실패");
        }
    }
}
