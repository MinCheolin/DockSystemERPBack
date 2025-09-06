package com.example.docksystem_erp.dto.StandardProcess;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StandardProcessCreateRequestDto {

    @NotBlank(message = "표준 공정 코드는 필수입니다.")
    private String spCode;
    @NotBlank(message = "표준 공정명은 필수입니다.")
    private String spName;
    @NotBlank(message = "표준 공정 내용은 필수입니다.")
    private String spDescription;
    @NotBlank(message = "표준 공정 시간은 필수입니다.")
    private String spTime;

}
