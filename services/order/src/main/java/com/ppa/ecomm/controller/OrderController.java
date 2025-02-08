package com.ppa.ecomm.controller;

import com.ppa.ecomm.records.OrderRequest;
import com.ppa.ecomm.records.OrderResponse;
import com.ppa.ecomm.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Integer> createOrder(
            @RequestBody @Valid OrderRequest request
            ){
        return ResponseEntity.ok(orderService.createOrder(request));
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> findAll() {
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping("/{order_id}")
    public ResponseEntity<OrderResponse> findOrderById(
            @PathVariable("order_id") Integer orderId
    ){
        return ResponseEntity.ok(orderService.findById(orderId));
    }
}
