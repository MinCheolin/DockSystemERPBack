package com.example.docksystem_erp.dto.Equipment;

import com.example.docksystem_erp.entity.Equipment.EquipmentStatusType;
import lombok.Data;

import java.util.Date;

@Data
public class EquipmentUpdateRequestDto {
    private String equipCode;
    private String equipName;
    private EquipmentStatusType type;
    private Long equipPrice;
    private Long equipDepreciation;
    private Date equipPurchaseDate;
    private Date equipLastInspected;
    private Long userNo;
}
