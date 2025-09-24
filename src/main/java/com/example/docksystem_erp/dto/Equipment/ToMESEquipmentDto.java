package com.example.docksystem_erp.dto.Equipment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ToMESEquipmentDto {
    @JsonProperty("equipNo")
    private String erpEquipNo;
    @JsonProperty("equipCode")
    private String equipCode;
    @JsonProperty("equipName")
    private String equipName;
}
