package com.example.docksystem_erp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectNo;
    @Column(nullable = false)
    private Date projectStartDate;
    @Column(nullable = false)
    private Date projectEndDate;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProjectType type;
    @Column(nullable = false)
    private String projectArch;
    @OneToOne
    @JoinColumn(name = "order_no")
    private Order order;
}
