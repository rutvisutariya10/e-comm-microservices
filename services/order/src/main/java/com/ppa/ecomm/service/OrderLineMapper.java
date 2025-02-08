package com.ppa.ecomm.service;

import com.ppa.ecomm.entity.Order;
import com.ppa.ecomm.entity.OrderLine;
import com.ppa.ecomm.records.OrderLineRequest;
import com.ppa.ecomm.records.OrderLineResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderLineMapper {
    public OrderLine toOrderLine(OrderLineRequest request) {
        return OrderLine.builder()
                .id(request.id())
                .quantity(request.quantity())
                .order(
                        Order.builder()
                                .id(request.orderId())
                                .build()
                )
                .productId(request.productId())
                .build();
    }

    public OrderLineResponse toOrderLineResponse(OrderLine orderLine) {
        return new OrderLineResponse(
                orderLine.getId(),
                orderLine.getQuantity()
        );
    }
}
