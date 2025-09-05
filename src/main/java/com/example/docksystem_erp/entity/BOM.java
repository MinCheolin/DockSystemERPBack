package com.example.docksystem_erp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "boms")
public class BOM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bomNo;
    @OneToOne
    @JoinColumn(name = "project_no")
    private Project project;
}
