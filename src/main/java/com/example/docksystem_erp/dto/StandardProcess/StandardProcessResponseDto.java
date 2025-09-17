package com.example.docksystem_erp.dto.StandardProcess;

import com.example.docksystem_erp.dto.BOM.BOMResponseDto;
import com.example.docksystem_erp.dto.Customer.CustomerResponseDto;
import com.example.docksystem_erp.dto.Vessel.VesselResponseDto;
import com.example.docksystem_erp.entity.BOM.BOM;
import com.example.docksystem_erp.entity.StandardProcess.StandardProcess;
import lombok.Data;
import lombok.Getter;

@Data
public class StandardProcessResponseDto {
    private Long spNo;
    private String spCode;
    private String spName;
    private String spTime;
    private String spDescription;
    private String spEquipment;

    /*
    public StandardProcessResponseDto(StandardProcess standardProcess){
        this.spNo = standardProcess.getSpNo();
        this.spCode = standardProcess.getSpName();
        this.spName = standardProcess.getSpName();
        this.spTime = standardProcess.getSpTime();
        this.spDescription = standardProcess.getSpDescription();
        this.spEquipment = standardProcess.getSpEquipment();
    }*/

    public static StandardProcessResponseDto fromEntity(StandardProcess sp){
        StandardProcessResponseDto dto = new StandardProcessResponseDto();
        dto.setSpNo(sp.getSpNo());
        dto.setSpCode(sp.getSpCode());
        dto.setSpName(sp.getSpName());
        dto.setSpTime(sp.getSpTime());
        dto.setSpDescription(sp.getSpDescription());
        dto.setSpDescription(sp.getSpDescription());
        return dto;
    }

}
