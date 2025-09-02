package com.example.docksystem_erp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNo;
    @Column(nullable = false,length = 50)
    private String userName;
    @Column(nullable = false,unique = true,length = 50)
    private String userId;
    @Column(nullable = false,length = 50)
    private String userPw;
    @Column(nullable = false,length = 100)
    private String userPhone;
    @Column(nullable = false,length = 50)
    private String userWork;
    @Column(nullable = false)
    private Long userSalary;
    @ManyToOne
    @JoinColumn(name = "department_no")
    private Department department;
    @ManyToOne
    @JoinColumn(name = "role_no")
    private Role role;
}
