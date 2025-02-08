package com.ppa.ecomm.records.product;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PurchaseRequest(
        @NotNull(message = "Product is Required.")
        Integer productId,
        @Positive(message = "Quantity is Required.")
        double quantity
) {
}
