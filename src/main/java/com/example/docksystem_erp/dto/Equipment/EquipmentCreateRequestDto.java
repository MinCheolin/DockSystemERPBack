package com.example.docksystem_erp.dto.Equipment;

import com.example.docksystem_erp.entity.Equipment.EquipmentStatusType;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    private Long equipPrice;
    @NotBlank(message = "장비 감가 상각은 필수입니다.")
    private Long equipDepreciation;
    @NotBlank(message = "장비 구매일은 필수입니다")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date equipPurchaseDate;
    @NotBlank(message = "최근 점검일은 필수입니다.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date equipLastInspected;

}
