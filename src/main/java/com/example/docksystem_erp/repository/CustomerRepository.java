package com.example.docksystem_erp.repository;

import com.example.docksystem_erp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
