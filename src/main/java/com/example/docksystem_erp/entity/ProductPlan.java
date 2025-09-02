package com.example.docksystem_erp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "product_plans")
public class ProductPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ppNo;
    @Column(nullable = false,unique = true,length = 100)
    private String ppName;
    @Column(nullable = false)
    private Date ppStartDate;
    @Column(nullable = false)
    private Date ppEndDate;
    @ManyToOne
    @JoinColumn(name = "sp_no")
    private StandardProcess standardProcess;
    @ManyToOne
    @JoinColumn(name = "department_no")
    private Department department;
}
