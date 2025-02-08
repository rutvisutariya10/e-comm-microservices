package com.ppa.ecomm.records.customer;

public record CustomerResponse(
        String id,
        String firstname,
        String lastname,
        String email
) {
}
