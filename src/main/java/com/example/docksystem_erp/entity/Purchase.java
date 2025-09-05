package com.example.docksystem_erp.entity;

import com.example.docksystem_erp.dto.Purchase.PurchaseUpdateRequestDto;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "purchases")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long purchaseNo;
    @Column(nullable = false)
    private Date purchaseDate;
    @ManyToOne
    @JoinColumn(name = "user_no")
    private User user;
    @ManyToOne
    @JoinColumn(name = "client_no")
    private Client client;

    public void updatePurchase(PurchaseUpdateRequestDto requestDto){
        this.purchaseDate = requestDto.getPurchaseDate();
    }
}
