package com.example.docksystem_erp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "standard_processes")
public class StandardProcess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long spNo;
    @Column(nullable = false,unique = true,length = 50)
    private String spCode;
    @Column(nullable = false,length = 100)
    private String spName;
    @Column(nullable = false,length = 50)
    private String spTime;
    @Column(nullable = false,columnDefinition = "TEXT")
    private String spDescription;
}
