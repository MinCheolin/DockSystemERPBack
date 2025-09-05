package com.example.docksystem_erp.entity;

import com.example.docksystem_erp.dto.Client.ClientUpdateRequestDto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientNo;
    @Column(nullable = false,length = 100)
    private String clientName;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ClientType type;
    @Column(nullable = false,unique = true,length = 10)
    private String clientBrn;
    @Column(nullable = false,length = 50)
    private String clientCeo;
    @Column(nullable = false,length = 50)
    private String clientManager;
    @Column(nullable = false,length = 50)
    private String clientPhone;
    @Column(nullable = false,length = 50)
    private String clientAddress;
    @Column(nullable = false)
    private boolean clientStatus;

    public void updateClient(ClientUpdateRequestDto requestDto){
        this.clientName = requestDto.getClientName();
        this.type = requestDto.getType();
        this.clientBrn = requestDto.getClientBrn();
        this.clientCeo = requestDto.getClientCeo();
        this.clientManager = requestDto.getClientManager();
        this.clientPhone = requestDto.getClientPhone();
        this.clientAddress = requestDto.getClientAddress();
        this.clientStatus = requestDto.isClientStatus();
    }
}
