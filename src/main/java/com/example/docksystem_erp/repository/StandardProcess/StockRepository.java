package com.example.docksystem_erp.repository.StandardProcess;

import com.example.docksystem_erp.entity.Stock.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {

}
