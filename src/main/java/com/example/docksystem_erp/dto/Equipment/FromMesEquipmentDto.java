package com.example.docksystem_erp.dto.Equipment;

import com.example.docksystem_erp.entity.Equipment.EquipmentType;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class FromMesEquipmentDto {
    @JsonProperty("equipNo")
    private Long equipNo;
    @Enumerated(EnumType.STRING)
    private EquipmentType type;
}
