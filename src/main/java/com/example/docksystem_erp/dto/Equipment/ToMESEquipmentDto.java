package com.example.docksystem_erp.dto.Equipment;

import com.example.docksystem_erp.entity.Equipment.EquipmentType;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class ToMESEquipmentDto {
    @JsonProperty("equipNo")
    private String erpEquipNo;
    @JsonProperty("equipCode")
    private String equipCode;
    @JsonProperty("equipName")
    private String equipName;
    @Enumerated(EnumType.STRING)
    private EquipmentType type;
}
