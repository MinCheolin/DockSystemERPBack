package com.example.docksystem_erp.entity.BOM;

import com.example.docksystem_erp.entity.Material.Material;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "bomdetail")

public class BOMDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bom_detail_no")
    private Long bomDetailNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bom_no")
    private BOM bom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "material_no")
    private Material material;

    @Column(name = "bom_detail_count", nullable = false)
    private Long bomDetailCount;
}
