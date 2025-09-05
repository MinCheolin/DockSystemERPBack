package com.example.docksystem_erp.dto.Stock;

import com.example.docksystem_erp.entity.Material;
import com.example.docksystem_erp.entity.Stock.Stock;
import com.example.docksystem_erp.entity.Warehouse;

public class StockResponseDto {
        private Long stockNo;
        private int stockCount;
        private Warehouse warehouse;
        private Material material;

        public StockResponseDto(Stock stock){
            this.stockNo = stock.getStockNo();
            this.stockCount = stock.getStockCount();
            this.warehouse = stock.getWarehouse();
            this.material = stock.getMaterial();
        }

}
