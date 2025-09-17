package com.example.docksystem_erp.dto.Project;

import com.example.docksystem_erp.entity.Customer.Customer;
import com.example.docksystem_erp.entity.Project.Project;
import com.example.docksystem_erp.entity.Project.ProjectType;
import com.example.docksystem_erp.entity.Vessel.Vessel;
import lombok.Data;
import java.util.Date;

@Data
public class ProjectUpdateDto {
    private Long projectNo;
    private String projectName;
    private Date projectStartDate;
    private Date projectEndDate;
    private Long projectPrice;
    private ProjectType type;
    private String projectDesciption;
    private Long customerNo;
    private Long vesselNo;

    public Project toEntity(Customer customer, Vessel vessel){
        Project pjt = new Project();
        pjt.setProjectName(this.getProjectName());
        pjt.setProjectStartDate(this.getProjectStartDate());
        pjt.setProjectEndDate(this.getProjectEndDate());
        pjt.setProjectPrice(this.getProjectPrice());
        pjt.setType(this.getType());;
        pjt.setCustomer(customer);
        pjt.setVessel(vessel);
        return pjt;
    }

}
