package com.example.docksystem_erp.entity;

import com.example.docksystem_erp.dto.Equipment.EquipmentUpdateRequestDto;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "equipments")
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long equipNo;
    @Column(nullable = false,unique = true,length = 100)
    private String equipCode;
    @Column(nullable = false,length = 100)
    private String equipName;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EquipmentStatusType type;
    @Column(nullable = false)
    private Long equipPrice;
    @Column(nullable = false)
    private Long equipDepreciation;
    @Column(nullable = false)
    private Date equipPurchaseDate;
    @Column(nullable = false)
    private Date equipLastInspected;
    @ManyToOne
    @JoinColumn(name = "equip_manager_no")
    private User manager;

    public void updateEquipment(EquipmentUpdateRequestDto requestDto){
        this.equipCode = requestDto.getEquipCode();
        this.equipName = requestDto.getEquipName();
        this.type = requestDto.getType();
        this.equipPrice = requestDto.getEquipPrice();
        this.equipDepreciation = requestDto.getEquipDepreciation();
        this.equipPurchaseDate = requestDto.getEquipPurchaseDate();
        this.equipLastInspected = requestDto.getEquipLastInspected();
    }
}

