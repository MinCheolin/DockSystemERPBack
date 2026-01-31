package com.example.docksystem_erp.dto.StandardProcess;

import com.example.docksystem_erp.dto.Equipment.EquipmentResponseDto;
import com.example.docksystem_erp.entity.StandardProcess.StandardProcess;
import lombok.Data;

@Data
public class StandardProcessResponseDto {
    private Long spNo;
    private String spCode;
    private String spName;
    private String spTime;
    private String spDescription;
    private EquipmentResponseDto equipment;

    public static StandardProcessResponseDto fromEntity(StandardProcess sp){
        StandardProcessResponseDto dto = new StandardProcessResponseDto();
        dto.setSpNo(sp.getSpNo());
        dto.setSpCode(sp.getSpCode());
        dto.setSpName(sp.getSpName());
        dto.setSpTime(sp.getSpTime());
        dto.setSpDescription(sp.getSpDescription());
        dto.setEquipment(EquipmentResponseDto.fromEntity(sp.getEquipment()));
        return dto;
    }

}
