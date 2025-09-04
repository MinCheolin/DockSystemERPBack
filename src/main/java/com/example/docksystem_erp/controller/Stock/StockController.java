package com.example.docksystem_erp.controller.Stock;

import com.example.docksystem_erp.dto.Stock.StockRequestDto;
import com.example.docksystem_erp.dto.Stock.StockResponseDto;
import com.example.docksystem_erp.service.StandardProcess.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class StockController {
    private final StockService stockService;

    @GetMapping
    public ResponseEntity<List<StockResponseDto>> findAllStock(){
        return ResponseEntity.ok(stockService.findAllStock());
    }

    @PostMapping
    public ResponseEntity<Objects> CreateStock(@RequestBody StockRequestDto stockRequestDto){
        stockService.CreateStock(stockRequestDto);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{no}")
    public ResponseEntity<Objects> UpdateStock(@PathVariable("no") Long stockNo,StockRequestDto stockRequestDto){
        stockService.UpdateStock(stockNo,stockRequestDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{no}")
    public ResponseEntity<Objects> DeleteStock(@PathVariable("no") Long stockNo){
        stockService.Delete(stockNo);
        return ResponseEntity.noContent().build();
    }



}
