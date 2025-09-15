package com.example.docksystem_erp.service.StandardProcess;

import com.example.docksystem_erp.dto.StandardProcess.StandardProcessCreateRequestDto;
import com.example.docksystem_erp.dto.StandardProcess.StandardProcessRequestDto;

import com.example.docksystem_erp.dto.StandardProcess.StandardProcessResponseDto;
import com.example.docksystem_erp.entity.Equipment.Equipment;
import com.example.docksystem_erp.entity.StandardProcess.StandardProcess;
import com.example.docksystem_erp.repository.Equipment.EquipmentRepository;
import com.example.docksystem_erp.repository.StandardProcess.StandardProcessRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StandardProcessService {
    private final StandardProcessRepository spRepo;
    private final EquipmentRepository equipmentRepository;

    public List<StandardProcessResponseDto> findAllStandardProcess(){
        List<StandardProcessResponseDto> processes = spRepo.findAll()
                .stream()
                .map(StandardProcessResponseDto::new)
                .collect(Collectors.toList());
        return processes;
    }


    public StandardProcess CreateStandardProcess(StandardProcessCreateRequestDto requestDto){
        StandardProcess standardProcess = new StandardProcess();
        standardProcess.setSpCode(requestDto.getSpCode());
        standardProcess.setSpName(requestDto.getSpName());
        standardProcess.setSpDescription(requestDto.getSpDescription());
        standardProcess.setSpTime(requestDto.getSpTime());
        Equipment equipment = equipmentRepository.findById(requestDto.getEquipNo())
                .orElseThrow(()->new EntityNotFoundException("존재하지 않는 장비입니다."+requestDto.getEquipNo()));
        standardProcess.setEquipment(equipment);
        return spRepo.save(standardProcess);
    }

    public void UpdateStandardProcess(Long spNo, StandardProcessRequestDto spDto){
       StandardProcess spEntity = spRepo.findById(spNo).orElseThrow(() -> new EntityNotFoundException("해당 공정을 찾을 수 없습니다."));
        spEntity.setSpCode(spDto.getSpCode());
        spEntity.setSpName(spDto.getSpName());
        spEntity.setSpTime(spDto.getSpTime());
        spEntity.setSpDescription(spDto.getSpDescription());
        Equipment equipment = equipmentRepository.findById(spDto.getEquipNo())
                .orElseThrow(()->new EntityNotFoundException("존재하지 않는 장비입니다."+spDto.getEquipNo()));
        spEntity.setEquipment(equipment);
        spRepo.save(spEntity);
    }

    public void DeleteStandardProcess(Long spNo){
        StandardProcess spEntity = spRepo.findById(spNo).orElseThrow(() -> new EntityNotFoundException("해당 공정을 찾을 수 없습니다."));
        spRepo.delete(spEntity);
    }


}
