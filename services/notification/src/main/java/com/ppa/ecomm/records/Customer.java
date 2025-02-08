package com.ppa.ecomm.records;

public record Customer(
        String id,
        String firstname,
        String lastname,
        String email
) {
}
