package com.example.docksystem_erp.repository.Purchase;

import com.example.docksystem_erp.entity.Purchase.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase,Long> {
}
