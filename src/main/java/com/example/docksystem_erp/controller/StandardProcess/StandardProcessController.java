package com.example.docksystem_erp.controller.StandardProcess;


import com.example.docksystem_erp.dto.StandardProcess.StandardProcessRequestDto;
import com.example.docksystem_erp.dto.StandardProcess.StandardProcessResponseDto;
import com.example.docksystem_erp.service.StandardProcess.StandardProcessService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class StandardProcessController {
    private final StandardProcessService spService;

    @GetMapping
    public ResponseEntity<List<StandardProcessResponseDto>> findAllStandardProcess(){
        return ResponseEntity.ok(spService.findAllStandardProcess());
    }


    @PostMapping
    public ResponseEntity<Objects> CreateStandardProcess(StandardProcessRequestDto spDto){
        spService.CreateStandardProcess(spDto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{no}")
    public ResponseEntity<Objects> UpdateStandardProcess(@PathVariable("no") Long spNo,@RequestBody StandardProcessRequestDto spDto){
        spService.UpdateStandardProcess(spNo,spDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{no}")
    public ResponseEntity<Objects> DeleteStandardProcess(@PathVariable("no") Long spNo){
        spService.DeleteStandardProcess(spNo);
        return ResponseEntity.noContent().build();
    }


}
