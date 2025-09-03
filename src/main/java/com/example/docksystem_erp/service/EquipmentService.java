package com.example.docksystem_erp.service;

import com.example.docksystem_erp.dto.Equipment.EquipmentCreateRequestDto;
import com.example.docksystem_erp.dto.Equipment.EquipmentResponseDto;
import com.example.docksystem_erp.dto.Equipment.EquipmentUpdateRequestDto;
import com.example.docksystem_erp.entity.Equipment;
import com.example.docksystem_erp.entity.User;
import com.example.docksystem_erp.repository.EquipmentRepository;
import com.example.docksystem_erp.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;
    private final UserRepository userRepository;
    @Autowired
    public EquipmentService(EquipmentRepository equipmentRepository,
                            UserRepository userRepository){
        this.equipmentRepository = equipmentRepository;
        this.userRepository = userRepository;
    }
    //새로운 장비 정보 생성
    public Equipment creasteEquipment(EquipmentCreateRequestDto requestDto){
        Equipment equipment = new Equipment();
        equipment.setEquipCode(requestDto.getEquipCode());
        equipment.setEquipName(requestDto.getEquipName());
        equipment.setType(requestDto.getType());
        equipment.setEquipPrice(requestDto.getEquipmentPrice());
        equipment.setEquipDepreciation(requestDto.getEquipDepreciation());
        equipment.setEquipPurchaseDate(requestDto.getEquipPurchaseDate());
        equipment.setEquipLastInspected(requestDto.getEquipLastInspected());
        User user = userRepository.findById(requestDto.getUserNo())
                .orElseThrow(()->new EntityNotFoundException("존재하지 않는 사용자입니다."+requestDto.getUserNo()));
        equipment.setManager(user);
        return equipmentRepository.save(equipment);
    }

    //db상 모든 창고 정보 조회
    public List<EquipmentResponseDto> getAllEquipment(){
        return equipmentRepository.findAll().stream()
                .map(EquipmentResponseDto::fromEntity)
                .collect(Collectors.toList());
    }

    //삭제
    public void deleteEquipment(Long equipNo){

        if(!equipmentRepository.existsById(equipNo)){
            throw new EntityNotFoundException("해당 No의 장비를 찾을 수 없습니다."+equipNo);
        }

        equipmentRepository.deleteById(equipNo);
    }

    //업데이트
    public Equipment updateEquipment(Long equipNo, EquipmentUpdateRequestDto requestDto){
        Equipment existingEquipment = equipmentRepository.findById(equipNo)
                .orElseThrow(()->new EntityNotFoundException("해당 No의 선박을 찾을 수 없습니다."+equipNo));
        User user = userRepository.findById(requestDto.getUserNo())
                .orElseThrow(()->new EntityNotFoundException("존재하지 않는 사용자입니다."+requestDto.getUserNo()));
        existingEquipment.updateEquipment(requestDto);
        existingEquipment.setManager(user);
        return existingEquipment;
    }
}
