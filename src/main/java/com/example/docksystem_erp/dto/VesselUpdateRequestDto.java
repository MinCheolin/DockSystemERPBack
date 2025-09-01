package com.example.docksystem_erp.dto;
// 생성, 수정

import lombok.Data;



@Data
public class VesselUpdateRequestDto {

    //여기도 수정되는부분이 어디일까 고민을해봤는데
    // 없을거같은데 ?

    private String vesselName;
    private String vesselType;
    private String vesselSize;


}
