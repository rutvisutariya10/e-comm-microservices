package com.ppa.ecomm.records;

import jakarta.validation.constraints.NotNull;

public record ProductPurchaseRequest(
        @NotNull(message = "Product Id is Required.")
        Integer productId,
        @NotNull(message = "Quantity is Required.")
        double quantity
) {
}
