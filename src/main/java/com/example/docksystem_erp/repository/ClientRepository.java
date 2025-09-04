package com.example.docksystem_erp.repository;

import com.example.docksystem_erp.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
