package com.ppa.ecomm.service;

import com.ppa.ecomm.entity.Order;
import com.ppa.ecomm.records.OrderRequest;
import com.ppa.ecomm.records.OrderResponse;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class OrderMapper {
    public Order toOrder(OrderRequest request) {
        return Order.builder()
                .id(request.id())
                .customerId(request.customerId())
                .reference(request.reference())
                .totalAmount(request.amount())
                .paymentMethod(request.paymentMethod())
                .build();
    }

    public OrderResponse fromOrder(Order order) {
        return new OrderResponse(
                order.getId(),
                order.getReference(),
                order.getTotalAmount(),
                order.getPaymentMethod(),
                order.getCustomerId()
        );
    }
}
