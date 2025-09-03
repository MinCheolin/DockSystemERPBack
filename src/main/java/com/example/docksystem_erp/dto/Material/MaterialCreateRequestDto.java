package com.example.docksystem_erp.dto.Material;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MaterialCreateRequestDto {

    @NotBlank(message = "자재의 코드는 필수입니다.")
    private String materialCode;
    @NotBlank(message = "자재의 이름은 필수입니다.")
    private String materialName;
    @NotBlank(message = "자재의 유형은 필수입니다.")
    private String materialType;
    @NotBlank(message = "자재의 규격은 필수입니다.")
    private String materialSize;
    @NotBlank(message = "자재의 단가는 필수입니다.")
    private Long materialPrice;
    @NotBlank(message = "자재의 단위는 필수입니다.")
    private String materialUnit;
}
