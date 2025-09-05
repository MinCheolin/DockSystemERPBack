package com.example.docksystem_erp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "overtimes")
public class Overtime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long overtimeNo;
    @Column(nullable = false)
    private Date overtimeDate;
    @Column(nullable = false)
    private int overtimeTime;
    @ManyToOne
    @JoinColumn(name = "user_no")
    private User user;
}
