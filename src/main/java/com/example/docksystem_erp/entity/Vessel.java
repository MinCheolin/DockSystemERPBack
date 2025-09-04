package com.example.docksystem_erp.entity;

import com.example.docksystem_erp.dto.Vessel.VesselUpdateRequestDto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "vessels")
public class Vessel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vesselNo;
    @Column(nullable = false,unique = true,length = 100)
    private String vesselName;
    @Column(nullable = false,length = 100)
    private String vesselType;
    @Column(nullable = false,length = 50)
    private String vesselSize;

    public void updateVessel(VesselUpdateRequestDto requestDto) {
        this.vesselName = requestDto.getVesselName();
        this.vesselType = requestDto.getVesselType();
        this.vesselSize = requestDto.getVesselSize();
    }
}
