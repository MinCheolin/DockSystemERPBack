package com.example.docksystem_erp.entity.ProductPlan;

import com.example.docksystem_erp.dto.ProductPlan.ProductPlanUpdateRequestDto;
//import com.example.docksystem_erp.entity.Project.Project;
import com.example.docksystem_erp.entity.Project.Project;
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

    @ManyToOne
    @JoinColumn(name = "project_no")
    private Project project;
//    @ManyToOne
//    @JoinColumn(name = "bom_no")
//    private BOM bomNo;

    public void updateProductPlan(ProductPlanUpdateRequestDto requestDto){
        this.ppName = requestDto.getPpName();
        this.ppStartDate = requestDto.getPpStartDate();
        this.ppEndDate = requestDto.getPpEndDate();

    }
}
