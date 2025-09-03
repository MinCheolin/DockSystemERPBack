package com.example.docksystem_erp.dto.Material;

import com.example.docksystem_erp.entity.Material;
import lombok.Data;

@Data
public class MaterialResponseDto {
    private Long materialNo;
    private String materialCode;
    private String materialName;
    private String materialType;
    private String materialSize;
    private Long materialPrice;
    private String materialUnit;

    public static MaterialResponseDto fromEntity(Material material){
        MaterialResponseDto dto = new MaterialResponseDto();
        dto.setMaterialNo(material.getMaterialNo());
        dto.setMaterialCode(material.getMaterialCode());
        dto.setMaterialName(material.getMaterialName());
        dto.setMaterialType(material.getMaterialType());
        dto.setMaterialSize(material.getMaterialSize());
        dto.setMaterialPrice(material.getMaterialPrice());
        dto.setMaterialUnit(material.getMaterialUnit());

        return dto;
    }
}
