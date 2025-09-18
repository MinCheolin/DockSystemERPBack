package com.example.docksystem_erp.dto.BOM.Bom;

import com.example.docksystem_erp.dto.BOM.BomDetail.BOMDetailCreateRequestDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BOMCreateRequestDto {

    @NotNull(message = "선박 번호를 입력해주세요.")
    private Long vesselNo;
    @NotNull(message = "표준공정번호를 입력해주세요")
    private Long spNo;
    @Valid
    private List<BOMDetailCreateRequestDto> bomDetailDtoList = new ArrayList<>();


}
