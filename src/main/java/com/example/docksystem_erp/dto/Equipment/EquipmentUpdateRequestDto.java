package com.example.docksystem_erp.dto.Equipment;

import com.example.docksystem_erp.entity.Equipment.EquipmentStatusType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class EquipmentUpdateRequestDto {
    private String equipCode;
    private String equipName;
    private EquipmentStatusType type;
    private Long equipPrice;
    private Long equipDepreciation;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date equipPurchaseDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date equipLastInspected;
}
