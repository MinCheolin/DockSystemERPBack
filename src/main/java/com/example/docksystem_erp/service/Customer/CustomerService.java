package com.example.docksystem_erp.service.Customer;

import com.example.docksystem_erp.dto.Customer.CustomerCreateRequestDto;
import com.example.docksystem_erp.dto.Customer.CustomerResponseDto;
import com.example.docksystem_erp.dto.Customer.CustomerUpdateRequestDto;
import com.example.docksystem_erp.entity.Customer.Customer;
import com.example.docksystem_erp.repository.Customer.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    //C
    public Customer createCustomers(CustomerCreateRequestDto requestDto){
        Customer customer = new Customer();
        customer.setCustomerName(requestDto.getCustomerName());
        customer.setCustomerBrn(requestDto.getCustomerBrn());
        customer.setCustomerCeo(requestDto.getCustomerCeo());
        customer.setCustomerManager(requestDto.getCustomerManager());
        customer.setCustomerPhone(requestDto.getCustomerPhone());
        customer.setCustomerAddress(requestDto.getCustomerAddress());
        return customerRepository.save(customer);
    }

    //R
    public List<CustomerResponseDto> getAllCustomers(){
        return  customerRepository.findAll().stream()
                .map(CustomerResponseDto::fromEntity)
                .collect(Collectors.toList());
    }

    //U
    public Customer updateCustomers(Long customerNo, CustomerUpdateRequestDto requestDto){
        Customer existingCustomer = customerRepository.findById(customerNo)
                .orElseThrow(() -> new EntityNotFoundException("해당 No의 고객사를 찾을 수 없습니다: " +customerNo));
        existingCustomer.updateCustomer(requestDto);

        return existingCustomer;
    }

    //D
    public void deleteCustomers(Long customerNo){
        if(customerRepository.existsById(customerNo)){
            throw new EntityNotFoundException("해당 No의 고객사를 찾을 수 없습니다.");
        }
    }
}