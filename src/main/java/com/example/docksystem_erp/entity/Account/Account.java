package com.example.docksystem_erp.entity.Account;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountNo;
    @Column(nullable = false,length = 100)
    private String accountName;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountStatus status;
    @Column(nullable = false,columnDefinition = "TEXT")
    private String accountDescription;
    @Column(nullable = false,length = 255)
    private String accountFile;
    @Column(nullable = false)
    private Date accountStartDate;
}
