package com.example.docksystem_erp.controller.BOM;

import com.example.docksystem_erp.dto.BOM.Bom.BOMCreateRequestDto;
import com.example.docksystem_erp.dto.BOM.Bom.BOMResponseDto;
import com.example.docksystem_erp.dto.BOM.Bom.BomUpdateRequestDto;
import com.example.docksystem_erp.entity.BOM.BOM;
import com.example.docksystem_erp.service.BOM.BOMService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/erp/v1/boms") // API 경로를 BOM에 맞게 수정
public class BOMController {
    private final BOMService bomService;

    // 1. BOM 전체 조회 (GET)
    @GetMapping
    public ResponseEntity<List<BOMResponseDto>> getAllBOMs() {
        List<BOMResponseDto> boms = bomService.getAllBOMs();
        return ResponseEntity.ok(boms);
    }

    // 3. BOM 생성 (POST)
    @PostMapping
    public ResponseEntity<BOMResponseDto> createBOM(@RequestBody BOMCreateRequestDto requestDto) {
        bomService.createBOM(requestDto);
        return ResponseEntity.noContent().build();
    }

    // 4. BOM 수정 (PUT)
    @PutMapping("/{bomNo}")
    public BOMResponseDto updateBOM(@PathVariable("bomNo") Long bomNo,@RequestBody BomUpdateRequestDto requestDto) {
        BOM updateBom = bomService.updateBOM(bomNo,requestDto);
        return BOMResponseDto.fromEntity(updateBom);
    }

    // 5. BOM 삭제 (DELETE)
    @DeleteMapping("/{bomNo}")
    public ResponseEntity<Void> deleteBOM(@PathVariable("bomNo") Long bomNo) {
        bomService.deleteBOM(bomNo);
        return ResponseEntity.noContent().build();
    }
}