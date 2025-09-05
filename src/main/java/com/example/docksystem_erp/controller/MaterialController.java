package com.example.docksystem_erp.controller;

import com.example.docksystem_erp.dto.Material.MaterialCreateRequestDto;
import com.example.docksystem_erp.dto.Material.MaterialResponseDto;
import com.example.docksystem_erp.dto.Material.MaterialUpdateRequestDto;
import com.example.docksystem_erp.entity.Material;
import com.example.docksystem_erp.service.MaterialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/erp/v1/materials")
public class MaterialController {
    private final MaterialService materialService;

    //All 자재 조회
    @GetMapping
    public ResponseEntity<List<MaterialResponseDto>> getAllMaterial(){
        List<MaterialResponseDto> materials = materialService.getAllMaterial();
        return ResponseEntity.ok(materials);
    }
    //Create
    @PostMapping
    public Material createMaterial(@RequestBody MaterialCreateRequestDto requestDto){
        return materialService.createMaterial(requestDto);
    }
    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaterial(@PathVariable("id")Long materialNo){
        materialService.deleteMaterial(materialNo);
        return ResponseEntity.noContent().build();
    }
    //Update
    @PutMapping("/{materialNo}")
    public MaterialResponseDto updateMaterial(@PathVariable("materialNo")Long materialNo, @RequestBody MaterialUpdateRequestDto requestDto){
        Material updateMaterial = materialService.updateMaterial(materialNo,requestDto);
        return MaterialResponseDto.fromEntity(updateMaterial);
    }
}
