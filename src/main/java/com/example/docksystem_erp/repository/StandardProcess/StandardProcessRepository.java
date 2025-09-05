package com.example.docksystem_erp.repository.StandardProcess;

import com.example.docksystem_erp.entity.StandardProcess.StandardProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StandardProcessRepository extends JpaRepository<StandardProcess, Long> {

}
