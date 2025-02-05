package com.ppa.ecomm.records;

import com.ppa.ecomm.document.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(
        String id,
        @NotNull(message = "Customer First Name is required")
        String firstname,
        @NotNull(message = "Customer Last Name is required")
        String lastname,
        @NotNull(message = "Customer Email is required")
        @Email(message="Not a valid email address")
        String email,
        Address address) {
}
