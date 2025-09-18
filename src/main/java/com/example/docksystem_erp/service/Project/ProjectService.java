package com.example.docksystem_erp.service.Project;

import com.example.docksystem_erp.dto.Project.ProjectCreateDto;
import com.example.docksystem_erp.dto.Project.ProjectResponseDto;
import com.example.docksystem_erp.dto.Project.ProjectUpdateDto;
import com.example.docksystem_erp.entity.BOM.BOM;
import com.example.docksystem_erp.entity.Customer.Customer;
import com.example.docksystem_erp.entity.Material.Material;
import com.example.docksystem_erp.entity.ProductPlan.ProductPlan;
import com.example.docksystem_erp.entity.Project.Project;
import com.example.docksystem_erp.entity.Vessel.Vessel;
import com.example.docksystem_erp.repository.BOM.BOMRepository;
import com.example.docksystem_erp.repository.Customer.CustomerRepository;
import com.example.docksystem_erp.repository.Project.ProjectRepository;
import com.example.docksystem_erp.repository.Vessel.VesselRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository pjtRepo;
    private final VesselRepository vesselRepo;
    private final CustomerRepository customerRepo;
    private final BOMRepository bomRepo;

    public List<ProjectResponseDto> FindAllProject (){
       return pjtRepo.findAll().stream()
               .map(ProjectResponseDto::fromEntity)
               .collect(Collectors.toList());

    }

    @Transactional
    public void CreateProject(ProjectCreateDto dto){

        Customer pjtCustomer = customerRepo.findById(dto.getCustomerNo())
                .orElseThrow(()-> new EntityNotFoundException("존재하지 않는 고객사입니다."));
        Vessel pjtVessel = vesselRepo.findById(dto.getVesselNo())
                .orElseThrow(()->new EntityNotFoundException("존재하지 않는 선박입니다."));
        final Project pjt = dto.toEntity(pjtCustomer,pjtVessel);

        List<ProductPlan> productPlans = Optional.ofNullable(dto.getProductPlans()).orElse(Collections.emptyList())
                .stream()
                .map(productPlanDto -> {
                    BOM bom = bomRepo.findById(productPlanDto.getBomNo()).orElseThrow(()->new EntityNotFoundException("존재하지 않는 bom"));
                    ProductPlan pp = productPlanDto.toEntity(productPlanDto, bom);
                    pp.setProject(pjt);
                    return pp;
                })
                .collect(Collectors.toList());
        pjt.setProductPlans(productPlans);

       pjtRepo.save(pjt);
    }

    public void UpdateProject(Long projectNo, ProjectUpdateDto updateDto) {
        Project updateProject = pjtRepo.findById(projectNo)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 프로젝트입니다."));
        Customer updateCustomer = customerRepo.findById(updateDto.getCustomerNo())
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 고객사입니다."));
        Vessel updateVessel = vesselRepo.findById(updateDto.getVesselNo())
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 선박입니다."));
        updateProject.UpdateProject( updateDto.toEntity(updateCustomer, updateVessel));
        pjtRepo.save(updateProject);
    }

    public void DeleteProject(Long projectNo){
        if(!pjtRepo.existsById(projectNo)){
            throw new EntityNotFoundException("해당 프로젝트를 찾을 수 없습니다."+projectNo);
        }
        pjtRepo.deleteById(projectNo);

    }

}
