package com.example.docksystem_erp.dto.Equipment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FromMesEquipmentDto {
    @JsonProperty("equipNo")
    private Long equipNo;
}
