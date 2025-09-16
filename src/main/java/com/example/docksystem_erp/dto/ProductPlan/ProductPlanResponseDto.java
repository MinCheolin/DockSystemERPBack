package com.example.docksystem_erp.dto.ProductPlan;

import com.example.docksystem_erp.entity.BOM.BOM;
import com.example.docksystem_erp.entity.ProductionPlan.ProductPlan;
import com.example.docksystem_erp.entity.Project.Project;
import lombok.Data;

import java.util.Date;

@Data
public class ProductPlanResponseDto {
    private Long ppNo;
    private String ppName;
    private Date ppStartDate;
    private Date ppEndDate;
//    private ProjectResponseDto project;
//    private BOMResponseDto bom;

    public static ProductPlanResponseDto fromEntity(ProductPlan productPlan){
        ProductPlanResponseDto dto = new ProductPlanResponseDto();
        dto.setPpNo(productPlan.getPpNo());
        dto.setPpName(productPlan.getPpName());
        dto.setPpStartDate(productPlan.getPpStartDate());
        dto.setPpEndDate(productPlan.getPpEndDate());
//        dto.setProject(ProjectResponseDto.fromEntity(productPlan.getProject()));
//        dto.setBom(BOMResponseDto.fromEntity(productPlan.getBOM()));
        return dto;
    }
}
