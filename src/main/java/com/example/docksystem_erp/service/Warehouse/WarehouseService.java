package com.example.docksystem_erp.service.Warehouse;

import com.example.docksystem_erp.dto.Warehouse.WarehouseCreateRequestDto;
import com.example.docksystem_erp.dto.Warehouse.WarehouseResponseDto;
import com.example.docksystem_erp.dto.Warehouse.WarehouseUpdateRequestDto;
import com.example.docksystem_erp.entity.Warehouse.Warehouse;
import com.example.docksystem_erp.repository.Warehouse.WarehouseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class WarehouseService {
    private final WarehouseRepository warehouseRepository;

    @Autowired
    public WarehouseService(WarehouseRepository warehouseRepository){
        this.warehouseRepository = warehouseRepository;
    }

    //새로운 창고 정보 생성(create)
    public Warehouse createWarehouse (WarehouseCreateRequestDto requestDto){
        Warehouse warehouse = new Warehouse();
        warehouse.setWhName(requestDto.getWhName());
        warehouse.setWhCode(requestDto.getWhCode());
        warehouse.setWhLocation(requestDto.getWhLocation());
        warehouse.setWhType(requestDto.getWhType());
        return warehouseRepository.save(warehouse);
    }

    // db상 모든 창고 정보를 조회
    public List<WarehouseResponseDto> getAllWarehouses(){
        return warehouseRepository.findAll().stream()
                .map(WarehouseResponseDto::fromEntity)
                .collect(Collectors.toList());
    }

    //Delete는 void
    public void deleteWarehouse(Long whNo){
        if(!warehouseRepository.existsById(whNo)){
            throw new EntityNotFoundException("해당 No의 창고를 찾을 수 없습니다.");
        }
        warehouseRepository.deleteById(whNo);
    }

    public Warehouse updateWarehouse (Long whNo, WarehouseUpdateRequestDto requestDto){
        Warehouse existingWarehouse = warehouseRepository.findById(whNo)
                .orElseThrow(()-> new EntityNotFoundException("해당 No의 창고를 찾을 수 없습니다:"+whNo));
        existingWarehouse.updateWarehouse(requestDto);

        return existingWarehouse;
    }
}
