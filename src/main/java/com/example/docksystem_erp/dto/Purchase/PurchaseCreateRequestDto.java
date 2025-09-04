package com.example.docksystem_erp.dto.Purchase;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class PurchaseCreateRequestDto {

    @NotBlank(message = "발주일은 필수입니다.")
    private Date purchaseDate;
    @NotNull(message = "담당자는 필수입니다.")
    private Long userNo;
    @NotNull(message = "거래처는 필수입니다.")
    private Long ClientNo;
}
