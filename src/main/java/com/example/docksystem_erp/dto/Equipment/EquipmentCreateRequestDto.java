package com.example.docksystem_erp.dto.Equipment;

import com.example.docksystem_erp.entity.EquipmentStatusType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Date;

@Data
public class EquipmentCreateRequestDto {

    @NotBlank(message = "장비의 코드는 필수입니다.")
    private String equipCode;
    @NotBlank(message = "장비의 이름은 필수입니다.")
    private String equipName;
    @Enumerated(EnumType.STRING)
    @NotBlank(message = "장비의 유형은 필수입니다.")
    private EquipmentStatusType type;
    @NotBlank(message = "장비 구매가는 필수입니다.")
    private Long equipmentPrice;
    @NotBlank(message = "장비 감가 상각은 필수입니다.")
    private Long equipDepreciation;
    @NotBlank(message = "장비 구매일은 필수입니다")
    private Date equipPurchaseDate;
    @NotBlank(message = "최근 점검일은 필수입니다.")
    private Date equipLastInspected;
    @NotBlank(message = "담당자는 필수입니다.")
    private Long userNo;
}
