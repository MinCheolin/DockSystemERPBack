package com.example.docksystem_erp.controller.ProductPlan;

import com.example.docksystem_erp.dto.ProductPlan.ProductPlanResponseDto;
import com.example.docksystem_erp.entity.ProductPlan.ProductPlan;
import com.example.docksystem_erp.service.ProductPlan.ProductPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/erp/v1/product_plans")
public class ProductPlanController {
    private final ProductPlanService productPlanService;

    @GetMapping
    public ResponseEntity<List<ProductPlanResponseDto>> getAllProductPlan(){
        List<ProductPlanResponseDto> product_plans = productPlanService.getAllProductPlan();
        return ResponseEntity.ok(product_plans);
    }

    @GetMapping("/mes/{ppNo}")
    public ResponseEntity<ProductPlanResponseDto> getProductPlan(@PathVariable("ppNo")Long ppNo){
        ProductPlanResponseDto productPlan = productPlanService.getProductPlan(ppNo);
        return ResponseEntity.ok(productPlan);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ProductPlanResponseDto>> getProductPlanFindByProjectNO(@PathVariable("id")Long projectNo){
        List<ProductPlanResponseDto> product_plans = productPlanService.findByPjtNo(projectNo);
        return ResponseEntity.ok(product_plans);
    }


}
