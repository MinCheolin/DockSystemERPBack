package com.example.docksystem_erp.service.BOM;

import com.example.docksystem_erp.dto.BOM.Bom.BOMResponseDto;
import com.example.docksystem_erp.dto.BOM.BomDetail.BomDetailResponseDto;
import com.example.docksystem_erp.dto.BOM.BomDetail.BomDetailUpdateRequestDto;
import com.example.docksystem_erp.entity.BOM.BOM;
import com.example.docksystem_erp.entity.BOM.BOMDetail;
import com.example.docksystem_erp.entity.Material.Material;
import com.example.docksystem_erp.repository.BOM.BOMDetailRepository;
import com.example.docksystem_erp.repository.BOM.BOMRepository;
import com.example.docksystem_erp.repository.Material.MaterialRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BOMDetailService {
    private BOMDetailRepository bomDetailRepository;
    private BOMRepository bomRepository;
    private MaterialRepository materialRepository;

    @Autowired
    public BOMDetailService(BOMDetailRepository bomDetailRepository,
                            BOMRepository bomRepository,
                            MaterialRepository materialRepository){
        this.bomDetailRepository = bomDetailRepository;
        this.bomRepository = bomRepository;
        this.materialRepository = materialRepository;
    }

    //모든 bom detail 조회
    public List<BomDetailResponseDto> getAllBomDetail(){
        return bomDetailRepository.findAll().stream()
                .map(BomDetailResponseDto::fromEntity)
                .collect(Collectors.toList());
    }

    //bom no에 해당해는 bom detail 조회
    public List<BomDetailResponseDto> getBomDetail(Long bomNo){
        return bomDetailRepository.findByBom_bomNo(bomNo).stream()
                .map(BomDetailResponseDto::fromEntity)
                .collect(Collectors.toList());
    }

    //삭제
    public void deleteBomDetail(Long bomDetailNo){
        if(!bomDetailRepository.existsById(bomDetailNo)){
            throw new EntityNotFoundException("해당 No의 bom detail를 찾을 수 없습니다.");
        }
        bomDetailRepository.deleteById(bomDetailNo);
    }
    
    //업데이트
    public BOMDetail updateBomDetail(Long bomDetailNo, BomDetailUpdateRequestDto requestDto){
        BOMDetail bomDetail= bomDetailRepository.findById(bomDetailNo)
                .orElseThrow(()->new EntityNotFoundException("해당 No의 bom detail을 찾을 수 없습니다."));
        BOM bom = bomRepository.findById(requestDto.getBomNo())
                .orElseThrow(()->new EntityNotFoundException("해당 No의 bom을 찾을 수 없습니다."));
        Material material = materialRepository.findById(requestDto.getMaterialNo())
                .orElseThrow(()->new EntityNotFoundException("해당 No의 자재를 찾을 수 없습니다."));
        bomDetail.setBom(bom);
        bomDetail.setMaterial(material);
        bomDetail.setBomDetailCount(requestDto.getBomDetailCount());
        return bomDetail;
    }
}
