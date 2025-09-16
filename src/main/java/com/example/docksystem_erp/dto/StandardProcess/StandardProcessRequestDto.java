package com.example.docksystem_erp.dto.StandardProcess;

import com.example.docksystem_erp.entity.StandardProcess.StandardProcess;
import lombok.Getter;
import lombok.Setter;

//게터세터추가
//service부분에서 필요해서추가했음. getSpCode, getSpName..등
@Getter
@Setter

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
