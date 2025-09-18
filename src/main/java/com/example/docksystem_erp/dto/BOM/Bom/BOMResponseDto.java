package com.example.docksystem_erp.dto.BOM.Bom;

import com.example.docksystem_erp.dto.StandardProcess.StandardProcessResponseDto;
import com.example.docksystem_erp.dto.Vessel.VesselResponseDto;
import com.example.docksystem_erp.entity.BOM.BOM;
import com.example.docksystem_erp.entity.BOM.BOMDetail;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class BOMResponseDto {
    private Long bomNo;
    private VesselResponseDto vessel;
    private StandardProcessResponseDto standardProcess;


    public static BOMResponseDto fromEntity(BOM bom){
        BOMResponseDto dto = new BOMResponseDto();
        dto.setBomNo(bom.getBomNo());
        dto.setVessel(VesselResponseDto.fromEntity(bom.getVessel()));
        dto.setStandardProcess(StandardProcessResponseDto.fromEntity(bom.getStandardProcess()));
        return dto;
    }

}
