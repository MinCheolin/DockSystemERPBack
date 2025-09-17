package com.example.docksystem_erp.dto.Project;

import com.example.docksystem_erp.entity.Customer.Customer;
import com.example.docksystem_erp.entity.Project.Project;
import com.example.docksystem_erp.entity.Project.ProjectType;
import com.example.docksystem_erp.entity.Vessel.Vessel;
import com.example.docksystem_erp.entity.ProductPlan.ProductPlan;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ProjectCreateDto {
    @NotBlank(message = "프로젝트 이름은 필수입니다.")
    private String projectName;
    @NotBlank(message = "프로젝트 시작일 필수입니다.")
    private Date projectStartDate;
    @NotBlank(message = "프로젝트 종료일  필수입니다.")
    private Date projectEndDate;
    @NotBlank(message = "계약 금액은 필수입니다.")
    private Long projectPrice;
    private String projectDescription;
    @NotBlank(message = "고객사명 필수입니다.")
    private Long customerNo;
    @NotBlank(message = "선박종류 필수입니다.")
    private Long vesselNo;
    private List<ProductPlan> productPlans;


    public Project toEntity(Customer customer, Vessel vessel){
        Project pjt = new Project();
        pjt.setProjectName(this.getProjectName());
        pjt.setProjectStartDate(this.getProjectStartDate());
        pjt.setProjectEndDate(this.getProjectEndDate());
        pjt.setProjectPrice(this.getProjectPrice());
        pjt.setProjectDescription(this.getProjectDescription());
        pjt.setType(ProjectType.Waiting);
        pjt.setCustomer(customer);
        pjt.setVessel(vessel);
        pjt.setProductPlans(this.getProductPlans());
        return pjt;
    }

}
