package com.example.docksystem_erp.controller.BOM;

import com.example.docksystem_erp.dto.BOM.BOMCreateRequestDto;
import com.example.docksystem_erp.dto.BOM.BOMResponseDto;
import com.example.docksystem_erp.dto.BOM.BomUpdateRequestDto;
import com.example.docksystem_erp.service.BOM.BOMService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/erp/v1/boms") // API 경로를 BOM에 맞게 수정
@CrossOrigin(origins = "http://localhost:3000")
public class BOMController {
    private final BOMService bomService;

    // 1. BOM 전체 조회 (GET)
    @GetMapping
    public ResponseEntity<List<BOMResponseDto>> getAllBOMs() {
        List<BOMResponseDto> boms = bomService.getAllBOMs();
        return ResponseEntity.ok(boms);
    }

    // 2. BOM 단일 조회 (GET by ID)
    @GetMapping("/{bomNo}")
    public ResponseEntity<BOMResponseDto> getBOMById(@PathVariable Long bomNo) {
        BOMResponseDto bom = bomService.getBOMById(bomNo);
        return ResponseEntity.ok(bom);
    }

    // 3. BOM 생성 (POST)
    @PostMapping
    public ResponseEntity<BOMResponseDto> createBOM(@Valid @RequestBody BOMCreateRequestDto requestDto) {
        BOMResponseDto createdBom = bomService.createBOM(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBom);
    }

    // 4. BOM 수정 (PUT)
    @PutMapping("/{bomNo}")
    public ResponseEntity<BOMResponseDto> updateBOM(@PathVariable Long bomNo, @Valid @RequestBody BomUpdateRequestDto requestDto) {
        BOMResponseDto updatedBom = bomService.updateBOM(bomNo, requestDto);
        return ResponseEntity.ok(updatedBom);
    }

    // 5. BOM 삭제 (DELETE)
    @DeleteMapping("/{bomNo}")
    public ResponseEntity<Void> deleteBOM(@PathVariable Long bomNo) {
        bomService.deleteBOM(bomNo);
        return ResponseEntity.noContent().build();
    }
}