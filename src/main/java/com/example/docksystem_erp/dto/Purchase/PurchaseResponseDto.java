package com.example.docksystem_erp.dto.Purchase;

import com.example.docksystem_erp.dto.Client.ClientResponseDto;
import com.example.docksystem_erp.dto.User.UserResponseDto;
import com.example.docksystem_erp.entity.Purchase;
import lombok.Data;

import java.util.Date;

@Data
public class PurchaseResponseDto {
    private Long purchaseNo;
    private Date purchaseDate;
    private UserResponseDto user;
    private ClientResponseDto client;

    public static PurchaseResponseDto fromEntity(Purchase purchase){
        PurchaseResponseDto dto = new PurchaseResponseDto();
        dto.setPurchaseNo(purchase.getPurchaseNo());
        dto.setPurchaseDate(purchase.getPurchaseDate());
        dto.setUser(UserResponseDto.fromEntity(purchase.getUser()));
        dto.setClient(ClientResponseDto.fromEntity(purchase.getClient()));
        return dto;
    }
}
