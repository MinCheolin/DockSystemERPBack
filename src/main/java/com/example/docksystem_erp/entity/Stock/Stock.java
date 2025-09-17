//package com.example.docksystem_erp.entity.Stock;
//
//import com.example.docksystem_erp.entity.Material.Material;
//import com.example.docksystem_erp.entity.Warehouse.Warehouse;
//import jakarta.persistence.*;
//import lombok.Builder;
//import lombok.Data;
//import lombok.RequiredArgsConstructor;
//
//@Entity
//@Data
//@Builder
//@RequiredArgsConstructor
//@Table(name = "stocks")
//public class Stock {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long stockNo;
//    @Column(nullable = false)
//    private int stockCount;
//    @ManyToOne
//    @JoinColumn(name = "wh_no")
//    private Warehouse warehouse;
//    @OneToOne
//    @JoinColumn(name = "material_no")
//    private Material material;
//
//
//    public void UpdateStock(Stock stock){
//        this.stockCount = stock.getStockCount();
//        this.warehouse = stock.getWarehouse();
//        this.material = stock.getMaterial();
//    }
//
//}