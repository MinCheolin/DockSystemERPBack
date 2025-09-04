package com.example.docksystem_erp.service.StandardProcess;

import com.example.docksystem_erp.dto.Stock.StockRequestDto;

import com.example.docksystem_erp.dto.Stock.StockResponseDto;
import com.example.docksystem_erp.entity.Stock.Stock;
import com.example.docksystem_erp.repository.StandardProcess.StockRepository;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StockService {
    private final StockRepository stockRepo;

    public List<StockResponseDto> findAllStock(){
        List<StockResponseDto> stocks = stockRepo.findAll()
                .stream()
                .map(StockResponseDto::new)
                .collect(Collectors.toList());
        return stocks;
    }

    public void CreateStock(StockRequestDto stockRequestDto){
        stockRepo.save(stockRequestDto.toEntity());
    }

    public void UpdateStock(Long stockNo, StockRequestDto stockRequestDto){
        Stock stockEntity = stockRepo.findById(stockNo).orElseThrow(()-> new EntityExistsException("해당 재고가 존재하지 않습니다."));
        stockEntity.UpdateStock(stockRequestDto.toEntity());
        stockRepo.save(stockEntity);

    }

    public void Delete(Long stockNo){
        Stock stockEntity = stockRepo.findById(stockNo).orElseThrow(()-> new EntityExistsException("해당 재고가 존재하지 않습니다."));
        stockRepo.delete(stockEntity);
    }



}
