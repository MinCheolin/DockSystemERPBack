package com.example.docksystem_erp.controller.Warehouse;

import com.example.docksystem_erp.dto.Warehouse.WarehouseCreateRequestDto;
import com.example.docksystem_erp.dto.Warehouse.WarehouseResponseDto;
import com.example.docksystem_erp.dto.Warehouse.WarehouseUpdateRequestDto;
import com.example.docksystem_erp.entity.Warehouse.Warehouse;
import com.example.docksystem_erp.service.Warehouse.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/erp/v1/wharehouses")
public class WarehouseController {
    private final WarehouseService warehouseService;


    // All 창고 정보를 조회하는 Read
    @GetMapping
    public ResponseEntity<List<WarehouseResponseDto>> getAllWarehouses(){
        List<WarehouseResponseDto> warehouses = warehouseService.getAllWarehouses();
        return ResponseEntity.ok(warehouses);

    }
    // 창고 만드는 Create
    @PostMapping
    public Warehouse createWarehouse(@RequestBody WarehouseCreateRequestDto requestDto){
        return warehouseService.createWarehouse(requestDto);
    }

    // 창고 지우는 Delete
    @DeleteMapping("/{id}") // id경로변수를 지정하는 변수
    public ResponseEntity<Void> deleteWarehouse(@PathVariable("id") Long whNo){
        warehouseService.deleteWarehouse(whNo);
        return ResponseEntity.noContent().build();
    }

    //창고 수정 Update
    @PutMapping("/{whNo}")
    public WarehouseResponseDto updateWarehouse(
            @PathVariable("whNo") Long whNo,
            @RequestBody WarehouseUpdateRequestDto requestDto){

        Warehouse updatedWarehouse = warehouseService.updateWarehouse(whNo, requestDto);
        return WarehouseResponseDto.fromEntity(updatedWarehouse);

    }



}
