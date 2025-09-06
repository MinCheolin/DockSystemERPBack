package com.example.docksystem_erp.dto.Stock;

import com.example.docksystem_erp.dto.Material.MaterialResponseDto;
import com.example.docksystem_erp.dto.Warehouse.WarehouseResponseDto;
import com.example.docksystem_erp.entity.Material.Material;
import com.example.docksystem_erp.entity.Stock.Stock;
import com.example.docksystem_erp.entity.Warehouse.Warehouse;

public class StockResponseDto {
        private Long stockNo;
        private int stockCount;
        private WarehouseResponseDto warehouse;
        private MaterialResponseDto material;

}
