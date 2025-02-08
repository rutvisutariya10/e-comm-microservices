package com.ppa.ecomm.records.payment;

import com.ppa.ecomm.enums.PaymentMethod;
import com.ppa.ecomm.records.customer.CustomerResponse;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}
