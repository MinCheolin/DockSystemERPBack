package com.example.docksystem_erp.dto.Customer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerCreateRequestDto {

    @NotBlank(message = "고객사의 이름은 필수입니다.")
    private String customerName;
    @NotBlank(message = "사업자 등록 번호는 필수입니다.")
    @Size(min = 12,max = 12,message = "사업자 등록 번호는 12자리여야 합니다.")
    private String customerBrn;
    @NotBlank(message = "대표명은 필수입니다.")
    private String customerCeo;
    @NotBlank(message = "담당자명은 필수입니다.")
    private String customerManager;
    @NotBlank(message = "연락처는 필수입니다.")
    private String customerPhone;

}