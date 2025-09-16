package com.example.docksystem_erp.dto.BOM;

import jakarta.validation.Valid;
import lombok.Data;

import java.util.List;

@Data
public class BomUpdateRequestDto {

    @Valid
    private List<BomDetailDto> bomDetails;

    @Data
    public static class BomDetailDto{

        private Long bomDetailNo;
        private Long materialNo;
        private Long bomDetailCount;

    }
}
