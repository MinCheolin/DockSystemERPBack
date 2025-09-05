package com.example.docksystem_erp.dto.Purchase;

import lombok.Data;

import java.util.Date;

@Data
public class PurchaseUpdateRequestDto {
    private Long purchaseNo;
    private Date purchaseDate;
    private Long userNo;
    private Long clientNO;
}
