package com.example.docksystem_erp.entity;

import com.example.docksystem_erp.dto.MaterialUpdateRequestDto;
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

    public void updateMaterial(MaterialUpdateRequestDto requestDto){
        this.materialCode = requestDto.getMaterialCode();
        this.materialName = requestDto.getMaterialName();
        this.materialType = requestDto.getMaterialType();
        this.materialSize = requestDto.getMaterialSize();
        this.materialPrice = requestDto.getMaterialPrice();
        this.materialUnit = requestDto.getMaterialUnit();
    }
}
