package com.example.docksystem_erp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "purchase_desc")
public class PurchaseDesc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long purchaseDescNo;
    @Column(nullable = false)
    private int purchaseCount;
    @Column(nullable = false)
    private Long purchasePrice;
    @ManyToOne
    @JoinColumn(name = "purchase_no")
    private Purchase purchase;
    @ManyToOne
    @JoinColumn(name = "material_no")
    private Material material;
}
