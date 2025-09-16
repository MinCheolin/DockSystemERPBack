package com.example.docksystem_erp.controller.ProductPlan;

import com.example.docksystem_erp.dto.ProductPlan.ProductPlanCreateRequestDto;
import com.example.docksystem_erp.dto.ProductPlan.ProductPlanResponseDto;
import com.example.docksystem_erp.dto.ProductPlan.ProductPlanUpdateRequestDto;
import com.example.docksystem_erp.entity.ProductionPlan.ProductPlan;
import com.example.docksystem_erp.service.ProductPlan.ProductPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/erp/v1/product_plans")
public class ProductPlanController {
    private final ProductPlanService productPlanService;

    // R
    @GetMapping
    public ResponseEntity<List<ProductPlanResponseDto>> getAllProductPlan(){
        List<ProductPlanResponseDto> product_plans = productPlanService.getAllProductPlan();
        return ResponseEntity.ok(product_plans);
    }

    // C
    @PostMapping
    public ProductPlan createProductPlan(@RequestBody ProductPlanCreateRequestDto requestDto){
        System.out.println(requestDto);
        return productPlanService.createProductPlan(requestDto);
    }

    // D
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductPlan(@PathVariable("id")Long ppNo){
        productPlanService.deleteProductPlan(ppNo);
        return ResponseEntity.noContent().build();
    }

    // U
    @PutMapping("/{ppNo}")
    public ProductPlanResponseDto updateProductPlan(@PathVariable("ppNo")Long ppNo, @RequestBody ProductPlanUpdateRequestDto requestDto){
        ProductPlan updateProductPlan = productPlanService.updateProductPlan(ppNo, requestDto);
        return ProductPlanResponseDto.fromEntity(updateProductPlan);
    }
}
