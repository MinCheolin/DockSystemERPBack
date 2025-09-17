package com.example.docksystem_erp.service.ProductPlan;

import com.example.docksystem_erp.dto.ProductPlan.ProductPlanCreateRequestDto;
import com.example.docksystem_erp.dto.ProductPlan.ProductPlanResponseDto;
import com.example.docksystem_erp.dto.ProductPlan.ProductPlanUpdateRequestDto;
import com.example.docksystem_erp.entity.ProductPlan.ProductPlan;
import com.example.docksystem_erp.repository.ProductPlan.ProductPlanRespository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductPlanService {
    private final ProductPlanRespository productPlanRespository;
//    private final ProjectRepository projectRepository;
//    private final BOMRepository bomRepository;
    @Autowired
    public ProductPlanService(ProductPlanRespository productPlanRespository
                              /*,ProjectRepository projectRepository,
                              BOMRepository bomRepository*/){
        this.productPlanRespository = productPlanRespository;
//        this.projectRepository = productPlanRespository;
//        this.bomRepository = bomRespository;
    }

    // C
    public ProductPlan createProductPlan(ProductPlanCreateRequestDto requestDto){
        ProductPlan productPlan = new ProductPlan();
        productPlan.setPpName(requestDto.getPpName());
        productPlan.setPpStartDate(requestDto.getPpStartDate());
        productPlan.setPpEndDate(requestDto.getPpEndDate());
//        Project project = projectRepository.findById(requestDto.getProjectNo())
//                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 프로젝트입니다." + requestDto.getProjectNo()));
//        productPlan.setProject(project);
//        BOM bom = bomRepository.findById(requestDto.getBOMNo())
//                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 BOM입니다." + requestDto.getBOMNo()));
//        productPlan.setBOM(bom);
        return productPlanRespository.save(productPlan);
    }

    // R
    public List<ProductPlanResponseDto> getAllProductPlan(){
        return productPlanRespository.findAll().stream()
                .map(ProductPlanResponseDto ::fromEntity)
                .collect(Collectors.toList());
    }

    // D
    public void deleteProductPlan(Long ppNo){
        if(!productPlanRespository.existsById(ppNo)){
            throw new EntityNotFoundException("해당 No의 생산 계획을 찾을 수 없습니다." + ppNo);
        }
        productPlanRespository.deleteById(ppNo);
    }

    // U
    public ProductPlan updateProductPlan(Long ppNo, ProductPlanUpdateRequestDto requestDto){
        ProductPlan existingProductPlan = productPlanRespository.findById(ppNo)
                .orElseThrow(() -> new EntityNotFoundException("해당 No의 생산 계획을 찾을 수 없습니다."));
//        Project project = projectRepository.findById(requestDto.getProjectNo())
//                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 프로젝트입니다." + requestDto.getProjectNo()));
//        BOM bom = bomRepository.findById(requestDto.getBOMNo())
//                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 BOM입니다." + requestDto.getBOMNo()));
        existingProductPlan.updateProductPlan(requestDto);
//        existingProductPlan.setProject(project);
//        existingProductPlan.setBOM(bom);
        return existingProductPlan;
    }
}
