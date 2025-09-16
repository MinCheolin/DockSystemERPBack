package com.example.docksystem_erp.controller.StandardProcess;


import com.example.docksystem_erp.dto.StandardProcess.StandardProcessCreateRequestDto;
import com.example.docksystem_erp.dto.StandardProcess.StandardProcessRequestDto;
import com.example.docksystem_erp.dto.StandardProcess.StandardProcessResponseDto;
import com.example.docksystem_erp.entity.StandardProcess.StandardProcess;
import com.example.docksystem_erp.service.StandardProcess.StandardProcessService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor

//해당부분 dev자체에 없었어가지고 추가
@RequestMapping("/api/erp/v1/standardprocesses")
//해당부분 프론트랑 연결하려고 추가
@CrossOrigin(origins = "http://localhost:3000")
public class StandardProcessController {
    private final StandardProcessService spService;

    @GetMapping
    public ResponseEntity<List<StandardProcessResponseDto>> findAllStandardProcess(){
        return ResponseEntity.ok(spService.findAllStandardProcess());
    }


    @PostMapping
    public StandardProcess CreateStandardProcess(@RequestBody StandardProcessCreateRequestDto spDto){
        return spService.CreateStandardProcess(spDto);

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
