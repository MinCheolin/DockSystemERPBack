package com.example.docksystem_erp.entity.StandardProcess;

import jakarta.persistence.*;
import lombok.*;


//어노테이션 수정
//Require -> noarg, Allargs
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "standard_processes")
public class StandardProcess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long spNo;
    //updatable = false << 이거 프론트에서 spCode는 읽기전용으로 만들어서 추가했음.
    @Column(nullable = false, unique = true, length = 50, updatable = false)
    private String spCode;
    @Column(nullable = false, length = 100)
    private String spName;
    @Column(nullable = false, length = 50)
    private String spTime;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String spDescription;

    public void UpdateStandardProcess(StandardProcess spEntity) {
        this.spCode = spEntity.getSpCode();
        this.spName = spEntity.getSpName();
        this.spTime = spEntity.getSpTime();
        this.spDescription = spEntity.getSpDescription();

    }
}