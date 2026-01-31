package com.example.docksystem_erp.controller.BOM;

import com.example.docksystem_erp.dto.BOM.BomDetail.BomDetailResponseDto;
import com.example.docksystem_erp.dto.BOM.BomDetail.BomDetailUpdateRequestDto;
import com.example.docksystem_erp.entity.BOM.BOMDetail;
import com.example.docksystem_erp.service.BOM.BOMDetailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/erp/v1/bomdetails")
public class BomDetailController {

    private final BOMDetailService bomDetailService;

    @GetMapping
    public ResponseEntity<List<BomDetailResponseDto>> getAllBomDetails() {
        List<BomDetailResponseDto> bomdetails = bomDetailService.getAllBomDetail();
        return ResponseEntity.ok(bomdetails);
    }

    @GetMapping("/{bomNo}")
    public ResponseEntity<List<BomDetailResponseDto>> getBomDetail(@PathVariable("bomNo") Long bomNo){
        List<BomDetailResponseDto> bomdetails = bomDetailService.getBomDetail(bomNo);
        return ResponseEntity.ok(bomdetails);
    }

    @PutMapping("/{bomDetailNo}")
    public BomDetailResponseDto updateBOMDetail(@PathVariable("bomDetailNo") Long bomNo, @Valid @RequestBody BomDetailUpdateRequestDto requestDto) {
        BOMDetail updateBomDetail = bomDetailService.updateBomDetail(bomNo, requestDto);
        return BomDetailResponseDto.fromEntity(updateBomDetail);
    }
    @DeleteMapping("/{bomDetailNo}")
    public ResponseEntity<Void> deleteBOMDetail(@PathVariable("bomDetailNo") Long id) {
        bomDetailService.deleteBomDetail(id);
        return ResponseEntity.noContent().build();
    }
}
