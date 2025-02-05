package com.ppa.ecomm.controller;


import com.ppa.ecomm.document.Customer;
import com.ppa.ecomm.records.CustomerRequest;
import com.ppa.ecomm.records.CustomerResponse;
import com.ppa.ecomm.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService service;

    @PostMapping
    public ResponseEntity<String> createCustomer(
            @RequestBody @Valid CustomerRequest request){
        return ResponseEntity.ok(service.createCustomer(request));
    }

    @PutMapping
    public ResponseEntity<Void> updateCustomer(
            @RequestBody @Valid CustomerRequest request){
        service.updateCustomer(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> findAllCustomers(){
        return ResponseEntity.ok(service.findAllCustomers());
    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> existsById(
            @PathVariable("id") String customerId
    ) {
        return ResponseEntity.ok(service.existsById(customerId));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<CustomerResponse> findById(
            @PathVariable("id") String customerId
    ) {
        return ResponseEntity.ok(service.findById(customerId));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(
            @PathVariable("id") String customerId){
        service.deleteById(customerId);
        return ResponseEntity.accepted().build();
    }
}
