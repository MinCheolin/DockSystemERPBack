package com.example.docksystem_erp.controller.Customer;

import com.example.docksystem_erp.dto.Customer.CustomerCreateRequestDto;
import com.example.docksystem_erp.dto.Customer.CustomerResponseDto;
import com.example.docksystem_erp.dto.Customer.CustomerUpdateRequestDto;
import com.example.docksystem_erp.entity.Customer.Customer;
import com.example.docksystem_erp.service.Customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/erp/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    //C
    @PostMapping
    public Customer createCustomer(@RequestBody CustomerCreateRequestDto requestDto) {
        return customerService.createCustomers(requestDto);
    }

    //R
    @GetMapping
    public ResponseEntity<List<CustomerResponseDto>> getAllCustomers() {
        List<CustomerResponseDto> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    //U
    @PutMapping("/{customerNo}")
    public CustomerResponseDto updateCustomers(
            @PathVariable("customerNo") Long customerNo,
            @RequestBody CustomerUpdateRequestDto requestDto) {

        Customer updatedCustomers = customerService.updateCustomers(customerNo, requestDto);
        return CustomerResponseDto.fromEntity(updatedCustomers);
    }

    //D
    @DeleteMapping("/{id}") // id경로변수를 지정하는 변수
    public ResponseEntity<Void> deleteCustomers(@PathVariable("id") Long customerNo) {
        customerService.deleteCustomers(customerNo);
        return ResponseEntity.noContent().build();
    }
}