package com.example.docksystem_erp.controller.Client;

import com.example.docksystem_erp.dto.Client.ClientCreateRequestDto;
import com.example.docksystem_erp.dto.Client.ClientResponseDto;
import com.example.docksystem_erp.dto.Client.ClientUpdateRequestDto;
import com.example.docksystem_erp.entity.Client.Client;
import com.example.docksystem_erp.service.Client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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
    public ResponseEntity<Objects> updateClient(
            @PathVariable("clientNo") Long clientNo,
            @RequestBody ClientUpdateRequestDto requestDto){

        clientService.updateClient(clientNo, requestDto);
        return ResponseEntity.noContent().build();
    }
}
