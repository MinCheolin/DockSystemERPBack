package com.example.docksystem_erp.dto.BOM;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.List;

@Data
public class BOMCreateRequestDto {

    @NotNull(message = "선박 번호를 입력해주세요.")
    private Long vesselNo;
    @NotNull(message = "표준공정번호를 입력해주세요")
    private Long spNo;
    @Valid //유효성검사를 실시해라. 아래 봄디테일dto 보고
    private List<BomDetailDto> bomDetailDtoList;

    @Data
    public static class BomDetailDto{
        @NotNull(message = "자재 번호는 필수입니다.")
        private Long materialNo;
        @NotNull(message = "수량은 필수입니다.")
        @Positive(message = "수량은 0보다 커야 합니다.")
        private Long bomDetailCount;
    }

}
