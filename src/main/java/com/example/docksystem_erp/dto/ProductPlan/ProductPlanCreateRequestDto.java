package com.example.docksystem_erp.dto.ProductPlan;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class ProductPlanCreateRequestDto {

    @NotBlank(message = "생산 계획명은 필수입니다.")
    private String ppName;
    @NotBlank(message = "시작일은 필수입니다.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date ppStartDate;
    @NotBlank(message = "마감일은 필수입니다.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date ppEndDate;
//    @NotNull(message = "프로젝트는 필수입니다.")
//    private Long projectNo;
//    @NotNull(message = "BOM은 필수입니다.")
//    private  Long bomNo;
}
