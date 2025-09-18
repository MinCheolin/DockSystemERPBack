package com.example.docksystem_erp.service.BOM;

import com.example.docksystem_erp.dto.BOM.Bom.BOMCreateRequestDto;
import com.example.docksystem_erp.dto.BOM.Bom.BOMResponseDto;
import com.example.docksystem_erp.dto.BOM.Bom.BomUpdateRequestDto;
import com.example.docksystem_erp.entity.BOM.BOM;
import com.example.docksystem_erp.entity.BOM.BOMDetail;
import com.example.docksystem_erp.entity.Material.Material;
import com.example.docksystem_erp.entity.StandardProcess.StandardProcess;
import com.example.docksystem_erp.entity.Vessel.Vessel;
import com.example.docksystem_erp.repository.BOM.BOMRepository;
import com.example.docksystem_erp.repository.Material.MaterialRepository;
import com.example.docksystem_erp.repository.StandardProcess.StandardProcessRepository;
import com.example.docksystem_erp.repository.Vessel.VesselRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class BOMService {
    private final BOMRepository bomRepository;
    private final VesselRepository vesselRepository;
    private final StandardProcessRepository standardProcessRepository;
    private final MaterialRepository materialRepository;

    @Autowired
    public BOMService(BOMRepository bomRepository,
                      VesselRepository vesselRepository,
                      StandardProcessRepository standardProcessRepository,
                      MaterialRepository materialRepository){
        this.bomRepository = bomRepository;
        this.vesselRepository = vesselRepository;
        this.standardProcessRepository = standardProcessRepository;
        this.materialRepository = materialRepository;
    }

    @Transactional
    public void createBOM(BOMCreateRequestDto requestDto){
        Vessel vessel = vesselRepository.findById(requestDto.getVesselNo())
                .orElseThrow(()-> new EntityNotFoundException("존재하지않는 선박입니다."+ requestDto.getVesselNo()));
        StandardProcess standardProcess = standardProcessRepository.findById(requestDto.getSpNo())
                .orElseThrow(()-> new EntityNotFoundException("존재하지 않는 공정입니다."+ requestDto.getSpNo()));

        BOM bom = new BOM();

        bom.setVessel(vessel);
        bom.setStandardProcess(standardProcess);

        List<BOMDetail> bomDetails = Optional.ofNullable(requestDto.getBomDetailDtoList())
                .orElse(Collections.emptyList())
                .stream()
                .map(detailDto -> {
                    Material material = materialRepository.findById(detailDto.getMaterialNo())
                            .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 자재입니다. ID: " + detailDto.getMaterialNo()));

                    BOMDetail bomDetail = new BOMDetail();
                    bomDetail.setMaterial(material);
                    bomDetail.setBomDetailCount(detailDto.getBomDetailCount());
                    bomDetail.setBom(bom);

                    return bomDetail;
                })
                .collect(Collectors.toList());
        bom.setBomDetails(bomDetails);
        bomRepository.save(bom);
    }

    //전체 조회
    public List<BOMResponseDto> getAllBOMs(){
        return bomRepository.findAll().stream()
                .map(BOMResponseDto::fromEntity)
                .collect(Collectors.toList());
    }

    public void deleteBOM(Long bomNo){
        if(!bomRepository.existsById(bomNo)){
            throw new EntityNotFoundException("해당 No의 BOM을 찾을 수 없습니다." + bomNo);
        }
        bomRepository.deleteById(bomNo);
    }


    public BOM updateBOM(Long bomNo, BomUpdateRequestDto requestDto){
        BOM bom = bomRepository.findById(bomNo)
                .orElseThrow(()-> new EntityNotFoundException("해당 No의 Bom을 찾을 수 없습니다."));
        
        Vessel vessel = vesselRepository.findById(requestDto.getVesselNo())
                .orElseThrow(()->new EntityNotFoundException("해당 No의 선박을 찾을 수 없습니다."));
        StandardProcess sp = standardProcessRepository.findById(requestDto.getSpNo())
                .orElseThrow(()->new EntityNotFoundException("해당 No의 표준 공정을 찾을 수 없습니다."));

        bom.setVessel(vessel);
        bom.setStandardProcess(sp);
        return bom;
    }

}
