package com.example.docksystem_erp.dto.BOM.BomDetail;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class BOMDetailCreateRequestDto {

    @NotNull(message = "BOM 번호는 필수입니다.")
    private Long bomNo;
    @NotNull(message = "자재 번호는 필수입니다.")
    private Long materialNo;
    @NotNull(message = "수량은 필수입니다.")
    private Long bomDetailCount;
}
