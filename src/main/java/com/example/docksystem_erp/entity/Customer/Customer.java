package com.example.docksystem_erp.entity.Customer;

import com.example.docksystem_erp.dto.Customer.CustomerUpdateRequestDto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerNo;
    @Column(nullable = false,length = 100)
    private String customerName;
    @Column(nullable = false,unique = true,length = 10)
    private String customerBrn;
    @Column(nullable = false,length = 50)
    private String customerCeo;
    @Column(nullable = false,length = 50)
    private String customerManager;
    @Column(nullable = false,length = 50)
    private String customerPhone;
    @Column(nullable = false,length = 100)
    private String customerAddress;

    public void updateCustomer(CustomerUpdateRequestDto requestDto){
        this.customerName = requestDto.getCustomerName();
        this.customerBrn = requestDto.getCustomerBrn();
        this.customerCeo = requestDto.getCustomerCeo();
        this.customerManager = requestDto.getCustomerManager();
        this.customerPhone = requestDto.getCustomerPhone();
        this.customerAddress = requestDto.getCustomerAddress();
    }
}
