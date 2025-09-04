package com.example.docksystem_erp.repository;

import com.example.docksystem_erp.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase,Long> {
}
