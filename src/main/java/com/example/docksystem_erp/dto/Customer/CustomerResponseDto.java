package com.example.docksystem_erp.dto.Customer;


import com.example.docksystem_erp.entity.Customer.Customer;
import lombok.Data;

@Data
public class CustomerResponseDto {
    private Long customerNo;
    private String customerName;
    private String customerBrn;
    private String customerCeo;
    private String customerManager;
    private String customerPhone;
    private String customerAddress;


    public static CustomerResponseDto fromEntity(Customer customer) {
        CustomerResponseDto dto = new CustomerResponseDto();
        dto.setCustomerNo(customer.getCustomerNo());
        dto.setCustomerName(customer.getCustomerName());
        dto.setCustomerBrn(customer.getCustomerBrn());
        dto.setCustomerCeo(customer.getCustomerCeo());
        dto.setCustomerManager(customer.getCustomerManager());
        dto.setCustomerPhone(customer.getCustomerPhone());
        dto.setCustomerAddress(customer.getCustomerAddress());

        return dto;
    }
}