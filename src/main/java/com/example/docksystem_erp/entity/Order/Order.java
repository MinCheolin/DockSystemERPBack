package com.example.docksystem_erp.entity.Order;

import com.example.docksystem_erp.entity.Customer.Customer;
import com.example.docksystem_erp.entity.Estimate.Estimate;
import com.example.docksystem_erp.entity.Vessel.Vessel;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderNo;
    @Column(nullable = false,unique = true,length = 100)
    private String projectName;
    @Column(nullable = false)
    private Long orderPrice;
    @Column(nullable = false)
    private Date orderDate;
    @Column(nullable = false)
    private Date orderEndDate;
    @Column(columnDefinition = "TEXT")
    private String orderDescription;
    @ManyToOne
    @JoinColumn(name = "customer_no")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "vessel_no")
    private Vessel vessel;
    @ManyToOne
    @JoinColumn(name = "estimate_no")
    private Estimate estimate;
}
