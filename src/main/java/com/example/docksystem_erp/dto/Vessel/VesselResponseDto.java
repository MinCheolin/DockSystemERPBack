package com.example.docksystem_erp.dto.Vessel;

import com.example.docksystem_erp.entity.Vessel;
import lombok.Data;

@Data
public class VesselResponseDto {
    private Long VesselNo;
    private String VesselName;
    private String VesselType;
    private String VesselSize;

    //아래는 웹클라이언트로 테스트할때 필요한거 정적메소드
    public static VesselResponseDto fromEntity(Vessel vessel){
        VesselResponseDto dto = new VesselResponseDto();
        dto.setVesselNo(vessel.getVesselNo());
        dto.setVesselName(vessel.getVesselName());
        dto.setVesselType(vessel.getVesselType());
        dto.setVesselSize(vessel.getVesselSize());

        return dto;

    }

}
