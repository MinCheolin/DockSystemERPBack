package com.example.docksystem_erp.dto.BOM;

import com.example.docksystem_erp.dto.Customer.CustomerResponseDto;
import com.example.docksystem_erp.dto.Project.ProjectResponseDto;
import com.example.docksystem_erp.dto.StandardProcess.StandardProcessResponseDto;
import com.example.docksystem_erp.dto.Vessel.VesselResponseDto;
import com.example.docksystem_erp.entity.BOM.BOM;
import com.example.docksystem_erp.entity.BOM.BOMDetail;
import com.example.docksystem_erp.entity.Project.Project;
import com.example.docksystem_erp.entity.StandardProcess.StandardProcess;
import com.example.docksystem_erp.entity.Vessel.Vessel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor

public class BOMResponseDto {
    private Long bomNo;
    private VesselResponseDto vessel;
    private StandardProcessResponseDto sp;


    public static BOMResponseDto fromEntity(BOM bom){
        BOMResponseDto dto = new BOMResponseDto();
        dto.setBomNo(bom.getBomNo());
        dto.setVessel(VesselResponseDto.fromEntity(bom.getVessel()));
        dto.setSp(StandardProcessResponseDto.fromEntity(bom.getStandardProcess()));
        return dto;
    }

    @Data
    public static class BomDetailDto{
        private Long materialNo;
        private String materialName;
        private String materialCode;
        private Long bomDetailCount;

        public BomDetailDto(BOMDetail bomDetail){
            this.materialNo = bomDetail.getMaterial().getMaterialNo();
            this.materialName = bomDetail.getMaterial().getMaterialName();
            this.materialCode = bomDetail.getMaterial().getMaterialCode();
            this.bomDetailCount = bomDetail.getBomDetailCount();
        }
    }
}
