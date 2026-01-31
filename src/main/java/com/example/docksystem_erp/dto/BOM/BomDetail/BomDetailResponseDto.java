package com.example.docksystem_erp.dto.BOM.BomDetail;

import com.example.docksystem_erp.dto.BOM.Bom.BOMResponseDto;
import com.example.docksystem_erp.dto.Material.MaterialResponseDto;
import com.example.docksystem_erp.entity.BOM.BOMDetail;
import lombok.Data;

@Data
public class BomDetailResponseDto {

    private Long bomDetailNo;
    private BOMResponseDto bom;
    private MaterialResponseDto material;
    private Long bomDetailCount;

    public static BomDetailResponseDto fromEntity(BOMDetail bomDetail){
        BomDetailResponseDto dto = new BomDetailResponseDto();
        dto.setBomDetailNo(bomDetail.getBomDetailNo());
        dto.setBom(BOMResponseDto.fromEntity(bomDetail.getBom()));
        dto.setMaterial(MaterialResponseDto.fromEntity(bomDetail.getMaterial()));
        dto.setBomDetailCount(bomDetail.getBomDetailCount());
        return dto;
    }
}
