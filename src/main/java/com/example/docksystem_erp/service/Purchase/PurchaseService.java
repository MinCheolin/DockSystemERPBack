package com.example.docksystem_erp.service.Purchase;

import com.example.docksystem_erp.dto.Purchase.PurchaseCreateRequestDto;
import com.example.docksystem_erp.dto.Purchase.PurchaseResponseDto;
import com.example.docksystem_erp.dto.Purchase.PurchaseUpdateRequestDto;
import com.example.docksystem_erp.entity.Client.Client;
import com.example.docksystem_erp.entity.Purchase.Purchase;
import com.example.docksystem_erp.entity.User.User;
import com.example.docksystem_erp.repository.Client.ClientRepository;
import com.example.docksystem_erp.repository.Purchase.PurchaseRepository;
import com.example.docksystem_erp.repository.User.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final UserRepository userRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public PurchaseService(PurchaseRepository purchaseRepository,
                           UserRepository userRepository,
                           ClientRepository clientRepository){
        this.purchaseRepository = purchaseRepository;
        this.userRepository = userRepository;
        this.clientRepository = clientRepository;
    }
    //새로운 발주 정보 생성
    public Purchase createPurchase(PurchaseCreateRequestDto requestDto){
        Purchase purchase = new Purchase();
        purchase.setPurchaseDate(requestDto.getPurchaseDate());
        User user = userRepository.findById(requestDto.getUserNo())
                .orElseThrow(()->new EntityNotFoundException("존재하지 않는 사용자입니다."+requestDto.getUserNo()));
        purchase.setUser(user);
        Client client = clientRepository.findById(requestDto.getClientNo())
                .orElseThrow(()->new EntityNotFoundException("존재하지 않는 거래처입니다."+requestDto.getClientNo()));
        purchase.setClient(client);
        return purchaseRepository.save(purchase);
    }
    //db상 모든 창고 정보 조회
    public List<PurchaseResponseDto> getAllPurchase(){
        return purchaseRepository.findAll().stream()
                .map(PurchaseResponseDto::fromEntity)
                .collect(Collectors.toList());
    }
    //삭제
    public void deletePurchase(Long purchaseNo){
        if(!purchaseRepository.existsById(purchaseNo)){
            throw new EntityNotFoundException("해당 No의 발주를 찾을 수 없습니다.");
        }
        purchaseRepository.deleteById(purchaseNo);
    }
    //업데이트
    public Purchase updatePurchase(Long purchaseNo,
                                   PurchaseUpdateRequestDto requestDto){
        Purchase existingPurchase = purchaseRepository.findById((purchaseNo))
                .orElseThrow(()->new EntityNotFoundException("해당 No의 발주를 찾을 수 없습니다."));
        User existingUser = userRepository.findById(requestDto.getUserNo())
                .orElseThrow(()->new EntityNotFoundException("해당 No의 사용자를 찾을 수 없습니다."));
        Client existingClient = clientRepository.findById(requestDto.getClientNO())
                .orElseThrow(()->new EntityNotFoundException("해당 No의 거래처를 찾을 수 없습니다."));
        existingPurchase.updatePurchase(requestDto);
        existingPurchase.setUser(existingUser);
        existingPurchase.setClient(existingClient);
        return existingPurchase;
    }
}
