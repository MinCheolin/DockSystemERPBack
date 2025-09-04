package com.example.docksystem_erp.dto.Warehouse;

import lombok.Data;

@Data

public class WarehouseUpdateRequestDto {

    private String whName;
    private String whCode;
    private String whLocation;
    private String whType;
}