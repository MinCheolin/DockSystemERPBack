package com.example.docksystem_erp.service.Vessel;

import com.example.docksystem_erp.dto.Vessel.MESVesselDto;
import com.example.docksystem_erp.dto.Vessel.VesselCreateRequestDto;
import com.example.docksystem_erp.dto.Vessel.VesselResponseDto;
import com.example.docksystem_erp.dto.Vessel.VesselUpdateRequestDto;
import com.example.docksystem_erp.entity.Vessel.Vessel;
import com.example.docksystem_erp.repository.Vessel.VesselRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class VesselService {
    private final VesselRepository vesselRepository;

    private final RestTemplate restTemplate;
    @Value("${mes.base-url}")
    private String mesApiUrl;

    @Autowired
    public VesselService(VesselRepository vesselRepository,RestTemplate restTemplate) {
        this.vesselRepository = vesselRepository;
        this.restTemplate = restTemplate;
    }

    //새로운 선박 정보 생성(Create)
    public Vessel createVessel(VesselCreateRequestDto requestDto){
        Vessel vessel = new Vessel();
        vessel.setVesselName(requestDto.getVesselName());
        vessel.setVesselType(requestDto.getVesselType());
        vessel.setVesselSize(requestDto.getVesselSize());

        Vessel newVessel = vesselRepository.save(vessel);

        MESVesselDto dto = new MESVesselDto();
        dto.setErpVesselNo(newVessel.getVesselNo().toString());
        dto.setMesVesselName(newVessel.getVesselName());
        dto.setMesVesselType(newVessel.getVesselType());
        sendVesselMES(dto);
        return newVessel;

    }

    //DB상 모든 선박 정보를 조회
    public List<VesselResponseDto> getAllVessels(){
        return vesselRepository.findAll().stream()
                .map(VesselResponseDto::fromEntity)
                .collect(Collectors.toList());
    }

    //Delete는 void로 !
    public void deleteVessel(Long vesselNo) {
        //삭제하려는 데이터가 DB에 실제로 있는지 확인하는 안전코드
        if(!vesselRepository.existsById(vesselNo)){
            throw new EntityNotFoundException("해당 No의 선박을 찾을 수 없습니다."+vesselNo);
        }
        //vesselNo확인해서 지우는거
        vesselRepository.deleteById(vesselNo);

        //mes로 delete 요쳥
        restTemplate.delete(mesApiUrl+"/vessels/"+vesselNo);

    }

    //수정하는거 ! update
    public Vessel updateVessel(Long vesselNo, VesselUpdateRequestDto requestDto) {
        Vessel existingVessel = vesselRepository.findById(vesselNo)
                .orElseThrow(() -> new EntityNotFoundException("해당 No의 선박을 찾을 수 없습니다:" + vesselNo));
        existingVessel.updateVessel(requestDto);

        Vessel updateVessel = vesselRepository.save(existingVessel);

        MESVesselDto dto = new MESVesselDto();
        dto.setErpVesselNo(updateVessel.getVesselNo().toString());
        dto.setMesVesselName(updateVessel.getVesselName());
        dto.setMesVesselType(updateVessel.getVesselType());
        sendVesselMES(dto);

        return updateVessel;
    }

    //mes 전송
    public void sendVesselMES(MESVesselDto dto){
        try {
            restTemplate.postForObject(mesApiUrl+"/vessels",dto,String.class);
            System.out.println("전송 성공");
        }catch (Exception e){
            System.err.println("전송 실패");
            e.printStackTrace();
        }
    }

}
