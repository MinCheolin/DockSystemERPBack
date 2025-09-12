package com.example.docksystem_erp.service.Client;

import com.example.docksystem_erp.dto.Client.ClientCreateRequestDto;
import com.example.docksystem_erp.dto.Client.ClientResponseDto;
import com.example.docksystem_erp.dto.Client.ClientUpdateRequestDto;
import com.example.docksystem_erp.entity.Client.Client;
import com.example.docksystem_erp.repository.Client.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    //새로운 거래처 생성(Create)
    public Client createClient (ClientCreateRequestDto requestDto){
        Client client = new Client();
        client.setClientName(requestDto.getClientName());
        client.setType(requestDto.getType());
        client.setClientBrn(requestDto.getClientBrn());
        client.setClientCeo(requestDto.getClientCeo());
        client.setClientManager(requestDto.getClientManager());
        client.setClientPhone(requestDto.getClientPhone());
        return clientRepository.save(client);
    }


    //모든 거래처 조회
    public List<ClientResponseDto> getAllClients(){
        return clientRepository.findAll().stream()
                .map(ClientResponseDto::fromEntity)
                .collect(Collectors.toList());
    }

    //삭제 Delete
    public void deleteClient(Long clientNo){
        if(!clientRepository.existsById(clientNo)){
            throw new EntityNotFoundException("해당 No의 거래처를 찾을 수 없습니다." + clientNo);
        }
        clientRepository.deleteById(clientNo);
    }


    public void updateClient (Long clientNo, ClientUpdateRequestDto requestDto){
        Client existingClient = clientRepository.findById(clientNo)
                .orElseThrow(()-> new EntityNotFoundException("해당 No의 클라이언트를 찾을 수 없습니다." + clientNo));
        existingClient.updateClient(requestDto);
        clientRepository.save(existingClient);
    }

}
