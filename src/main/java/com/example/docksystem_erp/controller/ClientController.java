package com.example.docksystem_erp.controller;

import com.example.docksystem_erp.dto.Client.ClientCreateRequestDto;
import com.example.docksystem_erp.dto.Client.ClientResponseDto;
import com.example.docksystem_erp.dto.Client.ClientUpdateRequestDto;
import com.example.docksystem_erp.entity.Client;
import com.example.docksystem_erp.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/erp/v1/clients")
public class ClientController {
    private final ClientService clientService;

    //거래처 전체 조회
    @GetMapping
    public ResponseEntity<List<ClientResponseDto>> getAllClients(){
        List<ClientResponseDto> clients = clientService.getAllClients();
        return ResponseEntity.ok(clients);


    }

    // 거래처 생성 Create
    @PostMapping
    public Client createClient(@RequestBody ClientCreateRequestDto requestDto){
        return clientService.createClient(requestDto);
    }

    //거래처 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable("id")Long clientNo){
        clientService.deleteClient(clientNo);
        return ResponseEntity.noContent().build();

    }

    //거래처수정
    @PutMapping("/{clientNo}")
    public ClientResponseDto updateClient(
            @PathVariable("clientNo") Long clientNo,
            @RequestBody ClientUpdateRequestDto requestDto){

        Client updateClient = clientService.updateClient(clientNo, requestDto);
        return ClientResponseDto.fromEntity(updateClient);
    }
}
