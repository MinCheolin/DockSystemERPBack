package com.example.docksystem_erp.dto.Stock;

import com.example.docksystem_erp.entity.Material;
import com.example.docksystem_erp.entity.Stock.Stock;
import com.example.docksystem_erp.entity.Warehouse;

public class StockRequestDto {
    private Long stockNo;
    private int stockCount;
    private Warehouse warehouse;
    private Material material;


    public Stock toEntity(){
        Stock stockEntity = Stock.builder()
                .stockNo(stockNo)
                .stockCount(stockCount)
                .warehouse(warehouse)
                .material(material)
                .build();
        return stockEntity;
    }





}
