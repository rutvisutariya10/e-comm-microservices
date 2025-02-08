package com.ppa.ecomm.records;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record Customer(
        String id,
        @NotNull(message = "First Name is Required.")
        String firstname,
        @NotNull(message = "Last Name is Required.")
        String lastname,
        @NotNull(message = "Email is Required.")
        @Email(message = "Email is not correctly formatted.")
        String email
) {
}
