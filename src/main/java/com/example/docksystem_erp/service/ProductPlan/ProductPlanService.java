package com.example.docksystem_erp.service.ProductPlan;

import com.example.docksystem_erp.dto.ProductPlan.ProductPlanCreateRequestDto;
import com.example.docksystem_erp.dto.ProductPlan.ProductPlanResponseDto;
import com.example.docksystem_erp.dto.ProductPlan.ProductPlanUpdateRequestDto;
import com.example.docksystem_erp.entity.BOM.BOM;
import com.example.docksystem_erp.entity.ProductPlan.ProductPlan;
import com.example.docksystem_erp.repository.BOM.BOMRepository;
import com.example.docksystem_erp.repository.ProductPlan.ProductPlanRespository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductPlanService {
    private final ProductPlanRespository productPlanRespository;
    private final BOMRepository bomRepo;

    public List<ProductPlanResponseDto> getAllProductPlan(){
        return productPlanRespository.findAll().stream()
                .map(ProductPlanResponseDto ::fromEntity)
                .collect(Collectors.toList());
    }

    public void deleteProductPlan(Long ppNo){
        if(!productPlanRespository.existsById(ppNo)){
            throw new EntityNotFoundException("해당 No의 생산 계획을 찾을 수 없습니다." + ppNo);
        }
        productPlanRespository.deleteById(ppNo);
    }

/*
    public void updateProductPlan(Long ppNo, ProductPlanUpdateRequestDto requestDto){
        ProductPlan existingProductPlan = productPlanRespository.findById(ppNo)
                .orElseThrow(() -> new EntityNotFoundException("해당 No의 생산 계획을 찾을 수 없습니다."));
        BOM bom = bomRepo.findById(requestDto.getBomNo())
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 BOM입니다."));

        existingProductPlan.updateProductPlan(requestDto,bom);
        productPlanRespository.save(existingProductPlan);
    }*/
}
