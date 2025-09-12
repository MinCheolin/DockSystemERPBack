package com.example.docksystem_erp.dto.Customer;

import lombok.Data;

@Data
public class CustomerUpdateRequestDto {

    private Long customerNo;
    private String customerName;
    private String customerBrn;
    private String customerCeo;
    private String customerManager;
    private String customerPhone;
}
