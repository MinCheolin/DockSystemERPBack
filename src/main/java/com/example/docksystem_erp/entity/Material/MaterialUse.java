package com.example.docksystem_erp.entity.Material;

import com.example.docksystem_erp.entity.BOM.BOM;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "material_use")
public class MaterialUse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long materialUseNo;
    @Column(nullable = false)
    private int bomCount;
    @Column(nullable = false)
    private int bom_Usable_Count;
    @ManyToOne
    @JoinColumn(name = "bom_no")
    private BOM bom;
    @ManyToOne
    @JoinColumn(name = "material_no")
    private Material material;
}
