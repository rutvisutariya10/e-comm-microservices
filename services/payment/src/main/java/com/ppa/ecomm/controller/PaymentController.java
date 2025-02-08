package com.ppa.ecomm.controller;

import com.ppa.ecomm.records.PaymentRequest;
import com.ppa.ecomm.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Integer> makePayment(
            @RequestBody @Valid PaymentRequest paymentRequest
    ){
        return ResponseEntity.ok(paymentService.makePayment(paymentRequest));
    }
}
