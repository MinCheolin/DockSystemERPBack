package com.example.docksystem_erp.entity.StandardProcess;

import com.example.docksystem_erp.entity.Equipment.Equipment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "standard_processes")
public class StandardProcess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long spNo;
    @Column(nullable = false,unique = true,length = 50, updatable = false)
    private String spCode;
    @Column(nullable = false,length = 100)
    private String spName;
    @Column(nullable = false,length = 50)
    private String spTime;
    @Column(nullable = false,columnDefinition = "TEXT")
    private String spDescription;
    @OneToOne
    @JoinColumn(nullable = false,name = "equip_no")
    private Equipment equipment;

}
