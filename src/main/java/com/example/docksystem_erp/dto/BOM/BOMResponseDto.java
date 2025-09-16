package com.example.docksystem_erp.dto.BOM;

import com.example.docksystem_erp.entity.BOM.BOM;
import com.example.docksystem_erp.entity.BOM.BOMDetail;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor

public class BOMResponseDto {
    private Long bomNo;
    private String vesselName;
    private String spName;
    private List<BomDetailDto> bomDetails;

    public BOMResponseDto(BOM bom){
        this.bomNo = bom.getBomNo();
        this.vesselName = bom.getVessel().getVesselName();
        this.spName = bom.getStandardProcess().getSpName();

        this.bomDetails = bom.getBomDetails().stream()
                .map(BomDetailDto::new)
                .collect(Collectors.toList());
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
