package com.example.docksystem_erp.dto.StandardProcess;

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
    private String spEquipment;


    public StandardProcess toEntity() {
        StandardProcess stndProcess = StandardProcess.builder()
                .spNo(spNo)
                .spCode(spCode)
                .spName(spName)
                .spTime(spTime)
                .spDescription(spDescription)
                .spEquipment(spEquipment)
                .build();
        return stndProcess;
    }
}
