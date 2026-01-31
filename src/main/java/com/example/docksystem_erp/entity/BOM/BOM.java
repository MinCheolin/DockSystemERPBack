package com.example.docksystem_erp.entity.BOM;

import com.example.docksystem_erp.entity.StandardProcess.StandardProcess;
import com.example.docksystem_erp.entity.Vessel.Vessel;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "boms")
public class BOM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bom_no")
    private Long bomNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vessel_no")
    private Vessel vessel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sp_no")
    private StandardProcess standardProcess;

    @OneToMany(mappedBy = "bom", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<BOMDetail> bomDetails = new ArrayList<>();

}
