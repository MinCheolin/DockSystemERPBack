package com.example.docksystem_erp.entity.Warehouse;

import com.example.docksystem_erp.dto.Warehouse.WarehouseUpdateRequestDto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "warehouses")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long whNo;
    @Column(nullable = false,length = 50)
    private String whName;
    @Column(nullable = false,unique = true,length = 50)
    private String whCode;
    @Column(nullable = false,length = 100)
    private String whLocation;
    @Column(nullable = false,length = 50)
    private String whType;

    public void updateWarehouse(WarehouseUpdateRequestDto requestDto) {
        this.whName = requestDto.getWhName();
        this.whCode = requestDto.getWhCode();
        this.whLocation = requestDto.getWhLocation();
        this.whType = requestDto.getWhType();
    }
}
