package com.example.docksystem_erp.dto.ProductPlan;

import lombok.Data;

import java.util.Date;

@Data
public class ProductPlanUpdateRequestDto {
    private Long ppNo;
    private String ppName;
    private String ppStatus;
    private Date ppStartDate;
    private Date ppEndDate;
    private Long bomNo;
}
