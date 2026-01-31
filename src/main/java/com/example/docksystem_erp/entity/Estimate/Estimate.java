package com.example.docksystem_erp.entity.Estimate;

import com.example.docksystem_erp.entity.Customer.Customer;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "estimates")
public class Estimate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long estimateNo;
    @Column(length = 50)
    private String estimateCustName;
    @Column(nullable = false,columnDefinition = "TEXT")
    private String estimateCustReq;
    @Column(nullable = false)
    private Long estimatePrice;
    @Column(nullable = false,length = 255)
    private String estimateArch;
    @OneToOne
    @JoinColumn(name = "customer_no")
    private Customer customer;
}
