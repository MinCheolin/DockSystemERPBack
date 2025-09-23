package com.example.docksystem_erp.repository.ProductPlan;

import com.example.docksystem_erp.entity.ProductPlan.ProductPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductPlanRepository extends JpaRepository<ProductPlan, Long> {
//    @Query(value = "SELECT * FROM product_plans WHERE project_no = :projectNo", nativeQuery = true)
//    List<ProductPlan> findByProjectNo(@Param("projectNo")  Long projectNo);
      List<ProductPlan> findByProject_ProjectNo(Long projectNo);
}


