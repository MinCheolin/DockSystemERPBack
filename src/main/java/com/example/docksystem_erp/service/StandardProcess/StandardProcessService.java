package com.example.docksystem_erp.service.StandardProcess;

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
                .map(StandardProcessResponseDto::new)
                .collect(Collectors.toList()); ;
        return processes;
    }


    public void CreateStandardProcess(StandardProcessRequestDto spDto){
        StandardProcess spEntity = spDto.toEntity();
        spRepo.save(spEntity);

    }

    public void UpdateStandardProcess(Long spNo, StandardProcessRequestDto spDto){
       StandardProcess spEntity = spRepo.findById(spNo).orElseThrow(() -> new EntityNotFoundException("해당 공정을 찾을 수 없습니다."));
       spEntity.UpdateStandardProcess(spDto.toEntity());
       spRepo.save(spEntity);
    }

    public void DeleteStandardProcess(Long spNo){
        StandardProcess spEntity = spRepo.findById(spNo).orElseThrow(() -> new EntityNotFoundException("해당 공정을 찾을 수 없습니다."));
        spRepo.delete(spEntity);
    }


}
