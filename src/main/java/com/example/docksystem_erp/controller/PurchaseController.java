package com.example.docksystem_erp.controller;

import com.example.docksystem_erp.dto.Purchase.PurchaseCreateRequestDto;
import com.example.docksystem_erp.dto.Purchase.PurchaseResponseDto;
import com.example.docksystem_erp.dto.Purchase.PurchaseUpdateRequestDto;
import com.example.docksystem_erp.entity.Purchase;
import com.example.docksystem_erp.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/erp/v1/purchases")
public class PurchaseController {

    private final PurchaseService purchaseService;

    //All 발주 정보 조회
    @GetMapping
    public ResponseEntity<List<PurchaseResponseDto>> getAllPurchase(){
        List<PurchaseResponseDto> purchases = purchaseService.getAllPurchase();
        return ResponseEntity.ok(purchases);
    }

    //Create
    public Purchase createPurchase(@RequestBody PurchaseCreateRequestDto requestDto){
        return purchaseService.createPurchase(requestDto);
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePurchase(@PathVariable("id")Long purchaseNo){
        purchaseService.deletePurchase(purchaseNo);
        return ResponseEntity.noContent().build();
    }

    //Update
    @PutMapping("/{purchaseNo}")
    public PurchaseResponseDto updatePurchase(@PathVariable("purchaseNo")Long purchaseNo,
                                              @RequestBody PurchaseUpdateRequestDto requestDto){
        Purchase updatePurchase = purchaseService.updatePurchase(purchaseNo,requestDto);
        return PurchaseResponseDto.fromEntity(updatePurchase);
    }
}

