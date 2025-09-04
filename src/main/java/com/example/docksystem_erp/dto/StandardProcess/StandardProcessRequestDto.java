package com.example.docksystem_erp.dto.StandardProcess;

import com.example.docksystem_erp.entity.StandardProcess.StandardProcess;

public class StandardProcessRequestDto {
    private Long spNo;
    private String spCode;
    private String spName;
    private String spTime;
    private String spDescription;


    public StandardProcess toEntity() {
        StandardProcess stndProcess = StandardProcess.builder()
                .spNo(spNo)
                .spCode(spCode)
                .spName(spName)
                .spTime(spTime)
                .spDescription(spDescription)
                .build();
        return stndProcess;
    }
}
