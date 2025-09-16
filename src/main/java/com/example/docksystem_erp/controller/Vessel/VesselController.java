package com.example.docksystem_erp.controller.Vessel;

import com.example.docksystem_erp.dto.Vessel.VesselCreateRequestDto;
import com.example.docksystem_erp.dto.Vessel.VesselResponseDto;
import com.example.docksystem_erp.dto.Vessel.VesselUpdateRequestDto;
import com.example.docksystem_erp.entity.Vessel.Vessel;
import com.example.docksystem_erp.service.Vessel.VesselService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/erp/v1/vessels")
@CrossOrigin(origins = "http://localhost:3000")
public class VesselController {
    private final VesselService vesselService;

    //All 선박 정보를 조회하는 Read
    @GetMapping
    public ResponseEntity<List<VesselResponseDto>> getAllVessels(){
        List<VesselResponseDto> vessels = vesselService.getAllVessels();
        return ResponseEntity.ok(vessels);
    }

    //선박 만드는 Create
    @PostMapping
    public Vessel createVessel(@RequestBody VesselCreateRequestDto requestDto){
        return vesselService.createVessel(requestDto);
    }

    // 지우는거 Delete
    @DeleteMapping("/{id}") //id 경로변수를 지정하는 변수
    public ResponseEntity<Void> deleteVessel(@PathVariable("id") Long vesselNo){
        vesselService.deleteVessel(vesselNo);
        return ResponseEntity.noContent().build();
    }
    // 수정 Update
    @PutMapping("/{vesselNo}")
    public VesselResponseDto updateVessel(
            @PathVariable("vesselNo") Long VesselNo,
            @RequestBody VesselUpdateRequestDto requestDto) {

        Vessel updatedVessel = vesselService.updateVessel(VesselNo, requestDto);
        return VesselResponseDto.fromEntity(updatedVessel);

    }


}
