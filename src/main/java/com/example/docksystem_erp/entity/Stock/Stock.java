package com.example.docksystem_erp.entity.Stock;

import com.example.docksystem_erp.entity.Material;
import com.example.docksystem_erp.entity.Warehouse;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "stocks")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stockNo;
    @Column(nullable = false)
    private int stockCount;
    @ManyToOne
    @JoinColumn(name = "wh_no")
    private Warehouse warehouse;
    @OneToOne
    @JoinColumn(name = "material_no")
    private Material material;


    public void UpdateStock(Stock stock){
        this.stockCount = stock.getStockCount();
        this.warehouse = stock.getWarehouse();
        this.material = stock.getMaterial();
    }

}