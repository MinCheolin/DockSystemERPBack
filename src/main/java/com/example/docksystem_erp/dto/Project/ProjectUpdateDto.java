package com.example.docksystem_erp.dto.Project;

import com.example.docksystem_erp.dto.ProductPlan.ProductPlanUpdateRequestDto;
import com.example.docksystem_erp.entity.Customer.Customer;
import com.example.docksystem_erp.entity.Project.Project;
import com.example.docksystem_erp.entity.Project.ProjectType;
import com.example.docksystem_erp.entity.Vessel.Vessel;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class ProjectUpdateDto {
    private Long projectNo;
    private String projectName;
    private Date projectStartDate;
    private Date projectEndDate;
    private Long projectPrice;
    private ProjectType type;
    private String projectDescription;
    private Long customerNo;
    private Long vesselNo;
    private List<ProductPlanUpdateRequestDto> productPlans;

    public Project toEntity(Customer customer, Vessel vessel){
        Project pjt = new Project();
        pjt.setProjectName(this.getProjectName());
        pjt.setProjectStartDate(this.getProjectStartDate());
        pjt.setProjectEndDate(this.getProjectEndDate());
        pjt.setProjectPrice(this.getProjectPrice());
        pjt.setProjectDescription(this.getProjectDescription());
        pjt.setType(this.getType());;
        pjt.setCustomer(customer);
        pjt.setVessel(vessel);
        return pjt;
    }

}
