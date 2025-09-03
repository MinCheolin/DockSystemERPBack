package com.example.docksystem_erp.dto.Material;

import lombok.Data;

@Data
public class MaterialUpdateRequestDto {
    private Long materialNo;
    private String materialCode;
    private String materialName;
    private String materialType;
    private String materialSize;
    private Long materialPrice;
    private String materialUnit;
}
