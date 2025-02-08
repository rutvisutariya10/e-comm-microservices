package com.ppa.ecomm.clients;

import com.ppa.ecomm.records.customer.CustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(
        name = "customer-service",
        url = "${application.config.customer-url}"
)
public interface CustomerClient {
    @GetMapping("/find/{customer_id}")
    Optional<CustomerResponse> findCustomerById(
            @PathVariable("customer_id") String customerId
    );
}