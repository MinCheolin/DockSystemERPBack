package com.example.docksystem_erp.dto.Warehouse;

import com.example.docksystem_erp.entity.Warehouse;
import lombok.Data;

@Data
public class WarehouseResponseDto {
    private Long whNo;
    private String whName;
    private String whCode;
    private String whLocation;
    private String whType;

    //아래는 웹 클라이언트로 테스트할때 필요한 정적메소드
    public static WarehouseResponseDto fromEntity(Warehouse warehouse){
        WarehouseResponseDto dto = new WarehouseResponseDto();
        dto.setWhNo(warehouse.getWhNo());
        dto.setWhName(warehouse.getWhName());
        dto.setWhCode(warehouse.getWhCode());
        dto.setWhLocation(warehouse.getWhLocation());
        dto.setWhType(warehouse.getWhType());

        return dto;
    }

}
