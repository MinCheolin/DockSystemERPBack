package com.example.docksystem_erp.repository;

import com.example.docksystem_erp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
