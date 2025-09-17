package com.example.docksystem_erp.service.BOM;

import com.example.docksystem_erp.dto.BOM.BOMCreateRequestDto;
import com.example.docksystem_erp.dto.BOM.BOMResponseDto;
import com.example.docksystem_erp.dto.BOM.BomUpdateRequestDto;
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

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
//@RequiredArgsConstructor << 이거쓰면 생성자 알아서 만들어주는데 쓸줄모름

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

    //아델 - 크리에이션
    @Transactional
    public BOMResponseDto createBOM(BOMCreateRequestDto requestDto){
        Vessel vessel = vesselRepository.findById(requestDto.getVesselNo())
                .orElseThrow(()-> new EntityNotFoundException("존재하지않는 선박입니다."+ requestDto.getVesselNo()));
        StandardProcess standardProcess = standardProcessRepository.findById(requestDto.getSpNo())
                .orElseThrow(()-> new EntityNotFoundException("존재하지 않는 공정입니다."+ requestDto.getSpNo()));


        BOM bom = new BOM();

        bom.setVessel(vessel);
        bom.setStandardProcess(standardProcess);

        List<BOMDetail> bomDetails = requestDto.getBomDetailDtoList().stream()
                .map(detailDto -> {

                    Material material = materialRepository.findById(detailDto.getMaterialNo())
                            .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 자재입니다. ID: " + detailDto.getMaterialNo()));



                            //새로운 bom entity 설정
                            BOMDetail bomDetail = new BOMDetail();
                            bomDetail.setMaterial(material);
                            bomDetail.setBomDetailCount(detailDto.getBomDetailCount());

                            //bomdetail이 어디 bom에 들어가는지
                            bomDetail.setBom(bom);

                            return bomDetail;

                }).collect(Collectors.toList());

                    bom.setBomDetails(bomDetails);
                    BOM savedBom = bomRepository.save(bom);
                    return new BOMResponseDto(savedBom);
    }

    //전체 조회
    public List<BOMResponseDto> getAllBOMs(){
        return bomRepository.findAll().stream()
                .map(BOMResponseDto::new)
                .collect(Collectors.toList());
    }

    // 1개씩 조회
    public BOMResponseDto getBOMById(Long bomNo){
        BOM bom = bomRepository.findById(bomNo)
                .orElseThrow(()-> new EntityNotFoundException("해당 No의 BOM을 찾을 수 없습니다." + bomNo));
        return new BOMResponseDto(bom);
    }


    //이승기 - 삭제
    public void deleteBOM(Long bomNo){
        if(!bomRepository.existsById(bomNo)){
            throw new EntityNotFoundException("해당 No의 BOM을 찾을 수 없습니다." + bomNo);
        }
        bomRepository.deleteById(bomNo);
    }

    //FX - 크리스탈(수정)
    public BOMResponseDto updateBOM(Long bomNo, BomUpdateRequestDto requestDto){
        BOM bom = bomRepository.findById(bomNo)
                .orElseThrow(()-> new EntityNotFoundException("해당 No의 Bom을 찾을 수 없습니다."));

        bom.getBomDetails().clear();

        List<BOMDetail> newBomDetails = requestDto.getBomDetails().stream()
                .map(detailDto->{
                    Material material = materialRepository.findById(detailDto.getMaterialNo())
                            .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 자재입니다. ID: " + detailDto.getMaterialNo()));


                    BOMDetail bomDetail = new BOMDetail();
                    bomDetail.setMaterial(material);
                    bomDetail.setBomDetailCount(detailDto.getBomDetailCount());
                    bomDetail.setBom(bom);

                    return bomDetail;
                }).toList();

        bom.getBomDetails().addAll(newBomDetails);

        return new BOMResponseDto(bom);
    }

}
