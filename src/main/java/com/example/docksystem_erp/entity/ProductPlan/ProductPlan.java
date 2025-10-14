package com.example.docksystem_erp.entity.ProductPlan;

import com.example.docksystem_erp.dto.ProductPlan.ProductPlanUpdateRequestDto;
import com.example.docksystem_erp.entity.BOM.BOM;
import com.example.docksystem_erp.entity.Department.Department;
import com.example.docksystem_erp.entity.Project.Project;
import com.example.docksystem_erp.entity.StandardProcess.StandardProcess;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "product_plans")
public class ProductPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ppNo;
    @Column(nullable = false,unique = true,length = 100)
    private String ppName;
    @Column(nullable = false)
    private Date ppStartDate;
    @Column(nullable = false)
    private Date ppEndDate;
    @Column(nullable = false)
    private String ppStatus;

    @ManyToOne(fetch = FetchType.LAZY)


    @JoinColumn(name = "project_no")
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bom_no", nullable = true)
    private BOM bom;

    public void updateProductPlan(ProductPlanUpdateRequestDto requestDto,BOM bom,Project pjt){
        this.ppName = requestDto.getPpName();
        this.ppStartDate = requestDto.getPpStartDate();
        this.ppEndDate = requestDto.getPpEndDate();
        this.ppStatus = requestDto.getPpStatus();
        this.project = pjt;
        this.bom = bom;
    }
}
