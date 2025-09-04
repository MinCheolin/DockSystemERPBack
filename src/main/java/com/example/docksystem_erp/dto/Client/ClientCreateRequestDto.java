package com.example.docksystem_erp.dto.Client;

import com.example.docksystem_erp.entity.ClientType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ClientCreateRequestDto {
    @NotBlank(message = "거래처의 이름은 필수입니다.")
    private String clientName;
    @Enumerated(EnumType.STRING)
    @NotBlank(message = "거래처의 타입은 필수입니다.")
    private ClientType type;
    @NotBlank(message = "거래처의 사업자등록번호는 필수입니다.")
    private String clientBrn;
    @NotBlank(message = "거래처의 대표명은 필수입니다.")
    private String clientCeo;
    @NotBlank(message = "거래처의 담당자명은 필수입니다.")
    private String clientManager;
    @NotBlank(message = "거래처의 전화번호는 필수입니다.")
    private String clientPhone;
    @NotBlank(message = "거래처의 주소 및 위치는 필수입니다.")
    private String clientAddress;
    @NotNull(message = "거래처의 상태는 필수입니다.")
    private Boolean clientStatus;
}
