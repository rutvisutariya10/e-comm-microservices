package com.ppa.ecomm.service;

import com.ppa.ecomm.entity.Payment;
import com.ppa.ecomm.records.PaymentRequest;
import org.springframework.stereotype.Service;

@Service
public class PaymentMapper {
    public Payment toPayment(PaymentRequest paymentRequest) {
        return new Payment().builder()
                .id(paymentRequest.id())
                .amount(paymentRequest.amount())
                .orderId(paymentRequest.orderId())
                .paymentMethod(paymentRequest.paymentMethod())
                .build();
    }
}
