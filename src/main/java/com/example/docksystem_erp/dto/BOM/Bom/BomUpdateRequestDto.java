package com.example.docksystem_erp.dto.BOM.Bom;

import jakarta.validation.Valid;
import lombok.Data;

import java.util.List;

@Data
public class BomUpdateRequestDto {

    private Long vesselNo;
    private Long spNo;

}
