package com.example.docksystem_erp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
//@DATA 가 세터 게터 다 포합시킴

public class VesselCreateRequestDto {
    // 생성 할때는 다 필수적으로 필요함.
    // 일단은 생성이라 전부다 필수로 적어둠 변경해야한다면 변경해야함.

    @NotBlank(message = "선박의 이름은 필수입니다.")
    private String vesselName;
    @NotBlank(message = "선박의 유형은 필수입니다.")
    private String vesselType;
    @NotBlank(message = "선박의 사이즈는 필수입니다.")
    private String vesselSize;


}