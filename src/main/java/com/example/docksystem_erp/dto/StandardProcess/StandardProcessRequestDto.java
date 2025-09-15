package com.example.docksystem_erp.dto.StandardProcess;

import com.example.docksystem_erp.dto.Equipment.EquipmentResponseDto;
import com.example.docksystem_erp.entity.Equipment.Equipment;
import com.example.docksystem_erp.entity.StandardProcess.StandardProcess;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StandardProcessRequestDto {
    private Long spNo;
    private String spCode;
    private String spName;
    private String spTime;
    private String spDescription;
    private Long equipNo;

    public StandardProcess toEntity(Equipment equipment) {
        StandardProcess stndProcess = StandardProcess.builder()
                .spNo(spNo)
                .spCode(spCode)
                .spName(spName)
                .spTime(spTime)
                .spDescription(spDescription)
                .equipment(equipment)
                .build();
        return stndProcess;
    }
}
