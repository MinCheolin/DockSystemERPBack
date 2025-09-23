package com.example.docksystem_erp.service.ProductPlan;


import com.example.docksystem_erp.dto.ProductPlan.ProductPlanResponseDto;
import com.example.docksystem_erp.repository.BOM.BOMRepository;
import com.example.docksystem_erp.repository.ProductPlan.ProductPlanRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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


    public List<ProductPlanResponseDto> findByPjtNo(Long projectNo){
        List<ProductPlanResponseDto> pps = productPlanRepository.findByProject_ProjectNo(projectNo).stream()
                .map(ProductPlanResponseDto::fromEntity)
                .collect(Collectors.toList());
        return pps;
    }

}
