package com.example.docksystem_erp.service.StandardProcess;

import com.example.docksystem_erp.dto.StandardProcess.StandardProcessCreateRequestDto;
import com.example.docksystem_erp.dto.StandardProcess.StandardProcessRequestDto;

import com.example.docksystem_erp.dto.StandardProcess.StandardProcessResponseDto;
import com.example.docksystem_erp.entity.StandardProcess.StandardProcess;
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

    public List<StandardProcessResponseDto> findAllStandardProcess(){
        List<StandardProcessResponseDto> processes = spRepo.findAll()
                .stream()
                .map(StandardProcessResponseDto::fromEntity)
                .collect(Collectors.toList()); ;
        return processes;
    }


    public StandardProcess CreateStandardProcess(StandardProcessCreateRequestDto requestDto){
        StandardProcess standardProcess = new StandardProcess();
        standardProcess.setSpCode(requestDto.getSpCode());
        standardProcess.setSpName(requestDto.getSpName());
        standardProcess.setSpDescription(requestDto.getSpDescription());
        standardProcess.setSpTime(requestDto.getSpTime());
        standardProcess.setSpEquipment(requestDto.getSpEquipment());
        return spRepo.save(standardProcess);
    }

    public void UpdateStandardProcess(Long spNo, StandardProcessRequestDto spDto){
       StandardProcess spEntity = spRepo.findById(spNo).orElseThrow(() -> new EntityNotFoundException("해당 공정을 찾을 수 없습니다."));
        spEntity.setSpCode(spDto.getSpCode());
        spEntity.setSpName(spDto.getSpName());
        spEntity.setSpTime(spDto.getSpTime());
        spEntity.setSpDescription(spDto.getSpDescription());
        spEntity.setSpEquipment(spDto.getSpEquipment());
        spRepo.save(spEntity);
    }

    public void DeleteStandardProcess(Long spNo){
        StandardProcess spEntity = spRepo.findById(spNo).orElseThrow(() -> new EntityNotFoundException("해당 공정을 찾을 수 없습니다."));
        spRepo.delete(spEntity);
    }


}
