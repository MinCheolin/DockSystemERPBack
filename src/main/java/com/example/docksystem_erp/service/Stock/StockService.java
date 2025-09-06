package com.example.docksystem_erp.service.Stock;

import com.example.docksystem_erp.dto.Stock.StockRequestDto;

import com.example.docksystem_erp.dto.Stock.StockResponseDto;
import com.example.docksystem_erp.entity.Stock.Stock;
import com.example.docksystem_erp.repository.Stock.StockRepository;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StockService {
    private final StockRepository stockRepo;

}
