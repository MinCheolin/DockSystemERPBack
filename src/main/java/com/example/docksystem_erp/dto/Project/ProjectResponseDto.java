package com.example.docksystem_erp.dto.Project;

import com.example.docksystem_erp.dto.Customer.CustomerResponseDto;
import com.example.docksystem_erp.dto.Vessel.VesselResponseDto;
import com.example.docksystem_erp.entity.Project.Project;
import com.example.docksystem_erp.entity.Project.ProjectType;

import lombok.Data;

import java.util.Date;

@Data
public class ProjectResponseDto {
    private Long projectNo;
    private String projectName;
    private Date projectStartDate;
    private Date projectEndDate;
    private Long projectPrice;
    private String projectDescription;
    private ProjectType type;
    private CustomerResponseDto customer;
    private VesselResponseDto vessel;


    public static ProjectResponseDto fromEntity(Project project){
        ProjectResponseDto dto = new ProjectResponseDto();
        dto.setProjectNo(project.getProjectNo());
        dto.setProjectName(project.getProjectName());
        dto.setProjectStartDate(project.getProjectStartDate());
        dto.setProjectEndDate(project.getProjectEndDate());
        dto.setType(project.getType());
        dto.setProjectPrice(project.getProjectPrice());
        dto.setProjectDescription(project.getProjectDescription());
        dto.setCustomer(CustomerResponseDto.fromEntity(project.getCustomer()));
        dto.setVessel(VesselResponseDto.fromEntity(project.getVessel()));
        return dto;
    }

}
