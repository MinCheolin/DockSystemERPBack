package com.example.docksystem_erp.dto.Material;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MESMaterialDto {
    @JsonProperty("materialNo")
    private String erpMaterialNo;
    @JsonProperty("materialCode")
    private String materialCode;
    @JsonProperty("materialName")
    private String materialName;
}
