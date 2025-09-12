package com.example.docksystem_erp.dto.Equipment;

import com.example.docksystem_erp.dto.User.UserResponseDto;
import com.example.docksystem_erp.entity.Equipment.Equipment;
import com.example.docksystem_erp.entity.Equipment.EquipmentStatusType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class EquipmentResponseDto {
    private Long equipNo;
    private String equipCode;
    private String equipName;
    private EquipmentStatusType type;
    private String typeLabel; // type 한글 값 저장
    private Long equipPrice;
    private Long equipDepreciation;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date equipPurchaseDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date equipLastInspected;

    public static EquipmentResponseDto fromEntity(Equipment equipment){
        EquipmentResponseDto dto = new EquipmentResponseDto();
        dto.setEquipNo(equipment.getEquipNo());
        dto.setEquipCode(equipment.getEquipCode());
        dto.setEquipName(equipment.getEquipName());
        dto.setType(equipment.getType());
        dto.setTypeLabel(equipment.getType().getLabel()); // type 한글값 저장 ex) 가동
        dto.setEquipPrice(equipment.getEquipPrice());
        dto.setEquipDepreciation(equipment.getEquipDepreciation());
        dto.setEquipPurchaseDate(equipment.getEquipPurchaseDate());
        dto.setEquipLastInspected(equipment.getEquipLastInspected());
        return dto;
    }

}
