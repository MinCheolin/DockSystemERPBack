package com.example.docksystem_erp.dto.Warehouse;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class WarehouseCreateRequestDto {

    @NotBlank(message = "창고의 이름은 필수입니다.")
    private String whName;
    @NotBlank(message = "창고의 코드는 필수입니다.")
    private String whCode;
    @NotBlank(message = "창고의 위치는 필수입니다.")
    private String whLocation;
    @NotBlank(message = "창고의 타입은필수입니다.")
    private String whType;


}
