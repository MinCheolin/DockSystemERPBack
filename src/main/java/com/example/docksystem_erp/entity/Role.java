package com.example.docksystem_erp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleNo;
    @Column(nullable = false,length = 50)
    private String roleName;
    @OneToMany(mappedBy = "role")
    private List<User> users;
}
