package com.example.docksystem_erp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "materials")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long materialNo;
    @Column(nullable = false,unique = true,length = 100)
    private String materialCode;
    @Column(nullable = false,length = 100)
    private String materialName;
    @Column(nullable = false,length = 100)
    private String materialType;
    @Column(nullable = false,length = 50)
    private String materialSize;
    @Column(nullable = false)
    private Long materialPrice;
    @Column(nullable = false,length = 50)
    private String materialUnit;
}
