package com.example.docksystem_erp.dto.StandardProcess;

import com.example.docksystem_erp.entity.StandardProcess.StandardProcess;

public class StandardProcessResponseDto {
    private Long spNo;
    private String spCode;
    private String spName;
    private String spTime;
    private String spDescription;

    public StandardProcessResponseDto(StandardProcess standardProcess){
        this.spNo = standardProcess.getSpNo();
        this.spCode = standardProcess.getSpName();
        this.spName = standardProcess.getSpName();
        this.spTime = standardProcess.getSpTime();
        this.spDescription = standardProcess.getSpDescription();
    }
}
