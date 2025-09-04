package com.example.docksystem_erp.dto.Client;

import com.example.docksystem_erp.entity.Client;
import com.example.docksystem_erp.entity.ClientType;
import lombok.Data;

@Data
public class ClientResponseDto {
    private Long clientNo;
    private String clientName;
    private ClientType type;
    private String typeLabel;
    private String clientBrn;
    private String clientCeo;
    private String clientManager;
    private String clientPhone;
    private String clientAddress;
    private boolean clientStatus;

    public static ClientResponseDto fromEntity(Client client) {
        ClientResponseDto dto = new ClientResponseDto();
        dto.setClientNo(client.getClientNo());
        dto.setClientName(client.getClientName());
        dto.setType(client.getType());
        dto.setTypeLabel(client.getType().getLabel());
        dto.setClientBrn(client.getClientBrn());
        dto.setClientCeo(client.getClientCeo());
        dto.setClientManager(client.getClientManager());
        dto.setClientPhone(client.getClientPhone());
        dto.setClientAddress(client.getClientAddress());
        dto.setClientStatus(client.isClientStatus());

        return dto;
    }
}
