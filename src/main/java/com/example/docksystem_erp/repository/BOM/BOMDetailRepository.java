package com.example.docksystem_erp.repository.BOM;

import com.example.docksystem_erp.entity.BOM.BOMDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BOMDetailRepository extends JpaRepository<BOMDetail,Long> {
    List<BOMDetail> findByBom_bomNo(Long bomNo);
}
