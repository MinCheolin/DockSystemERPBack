package com.example.docksystem_erp.service.ProductPlan;


import com.example.docksystem_erp.dto.ProductPlan.ProductPlanResponseDto;
import com.example.docksystem_erp.dto.ProductPlan.ProductPlanStatusUpdateDto;
import com.example.docksystem_erp.entity.ProductPlan.ProductPlan;
import com.example.docksystem_erp.repository.BOM.BOMRepository;
import com.example.docksystem_erp.repository.ProductPlan.ProductPlanRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductPlanService {
    private final ProductPlanRepository productPlanRepository;
    private final BOMRepository bomRepo;

    public List<ProductPlanResponseDto> getAllProductPlan(){
        return productPlanRepository.findAll().stream()
                .map(ProductPlanResponseDto ::fromEntity)
                .collect(Collectors.toList());
    }

    public ProductPlanResponseDto getProductPlan(Long ppNo){
        ProductPlan productPlan = productPlanRepository.findById(ppNo)
                .orElseThrow(()->new EntityNotFoundException("해당 No의 생산 계획이 존재하지 않습니다."));
        return ProductPlanResponseDto.fromEntity(productPlan);
    }

    public List<ProductPlanResponseDto> findByPjtNo(Long projectNo){
        List<ProductPlanResponseDto> pps = productPlanRepository.findByProject_ProjectNo(projectNo).stream()
                .map(ProductPlanResponseDto::fromEntity)
                .collect(Collectors.toList());
        return pps;
    }

    public void updateProductPlanStatus(Long ppNo, ProductPlanStatusUpdateDto dto){
        ProductPlan pp = productPlanRepository.findById(ppNo).orElseThrow(() -> new EntityNotFoundException("ProductPlan not found "));
        pp.setPpStatus(dto.getPpStatus());
    }


}
