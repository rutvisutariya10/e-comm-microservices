package com.ppa.ecomm.records;

import com.ppa.ecomm.enums.PaymentMethod;
import com.ppa.ecomm.records.product.PurchaseRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

public record OrderRequest(
        Integer id,
        String reference,
        @Positive(message = "Order Amount should be Positive.")
        BigDecimal amount,
        @NotNull(message = "Payment Method Required.")
        PaymentMethod paymentMethod,
        @NotEmpty(message = "Customer Id is Required.")
        @NotBlank(message = "Customer Id is Required.")
        @NotNull(message = "Customer Id is Required.")
        String customerId,
        @NotEmpty(message = "Atleast one Product should be Purchased.")
        List<PurchaseRequest> products
) {
}
