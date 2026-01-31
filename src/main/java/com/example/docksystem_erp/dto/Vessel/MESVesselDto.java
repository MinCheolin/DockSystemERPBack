package com.example.docksystem_erp.dto.Vessel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MESVesselDto {
    @JsonProperty("vesselNo")
    private String erpVesselNo;
    @JsonProperty("vesselName")
    private String mesVesselName;
    @JsonProperty("vesselType")
    private String mesVesselType;
}
