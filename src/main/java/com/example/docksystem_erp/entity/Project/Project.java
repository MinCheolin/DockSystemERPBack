package com.example.docksystem_erp.entity.Project;


import com.example.docksystem_erp.entity.Customer.Customer;
import com.example.docksystem_erp.entity.Vessel.Vessel;
import com.example.docksystem_erp.entity.ProductPlan.ProductPlan;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectNo;

    @Column(nullable = false, unique = true)
    private String projectName;

    @Column(nullable = false)
    private Date projectStartDate;
    @Column(nullable = false)
    private Date projectEndDate;

    @Column(nullable = false)
    private Long projectPrice;
    @Column(nullable = false)
    private String projectDescription;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProjectType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_no")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vessel_no")
    private Vessel vessel;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductPlan> productPlans = new ArrayList<>();


    public void UpdateProject(Project pjt){
       this.projectName = pjt.getProjectName();
       this.projectStartDate = pjt.getProjectStartDate();
       this.projectEndDate = pjt.getProjectEndDate();
       this.projectPrice = pjt.getProjectPrice();
       this.projectDescription = pjt.getProjectDescription();
       this.type = pjt.getType();
       this.customer = pjt.customer;
       this.vessel = pjt.vessel;
    }
}
