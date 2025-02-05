package com.ppa.ecomm.service;

import com.ppa.ecomm.records.CustomerRequest;
import com.ppa.ecomm.document.Customer;
import com.ppa.ecomm.records.CustomerResponse;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;


@Service
public class CustomerMapper {
    public Customer toCustomer(@Valid CustomerRequest request) {
        if(request == null){
            return null;
        }
        return Customer.builder()
                .id(request.id())
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .address(request.address())
                .build();
    }

    public CustomerResponse fromCustomer(Customer customer) {
        return new CustomerResponse(
                customer.getId(),
                customer.getFirstname(),
                customer.getLastname(),
                customer.getEmail(),
                customer.getAddress()
        );
    }
}
