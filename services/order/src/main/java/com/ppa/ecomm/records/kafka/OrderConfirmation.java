package com.ppa.ecomm.records.kafka;

import com.ppa.ecomm.enums.PaymentMethod;
import com.ppa.ecomm.records.customer.CustomerResponse;
import com.ppa.ecomm.records.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
) {
}
