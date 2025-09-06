package com.example.docksystem_erp.repository.User;

import com.example.docksystem_erp.entity.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
