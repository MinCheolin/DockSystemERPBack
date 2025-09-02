package com.example.docksystem_erp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "stocks")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stockNo;
    @Column(nullable = false)
    private int stockCount;
    @ManyToOne
    @JoinColumn(name = "wh_no")
    private Warehouse warehouse;
    @OneToOne
    @JoinColumn(name = "material_no")
    private Material material;
}
