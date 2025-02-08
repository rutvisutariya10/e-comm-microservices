package com.ppa.ecomm.service;

import com.ppa.ecomm.clients.CustomerClient;
import com.ppa.ecomm.clients.PaymentClient;
import com.ppa.ecomm.exception.BusinessException;
import com.ppa.ecomm.clients.ProductClient;
import com.ppa.ecomm.records.OrderLineRequest;
import com.ppa.ecomm.records.OrderRequest;
import com.ppa.ecomm.records.OrderResponse;
import com.ppa.ecomm.records.kafka.OrderConfirmation;
import com.ppa.ecomm.records.payment.PaymentRequest;
import com.ppa.ecomm.records.product.PurchaseRequest;
import com.ppa.ecomm.repository.OrderRepository;
import com.ppa.ecomm.service.kafka.OrderProducer;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderMapper orderMapper;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;
    private final PaymentClient paymentClient;
    public Integer createOrder(@Valid OrderRequest request) {
        // Check Customer --> OpenFeign
        var customer = this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create Order. No Customer exists for the ID: " +request.customerId()));

        //purchase the products --> products-ms
        var purchasedProducts = this.productClient.purchaseProducts(request.products());

        // persist order
        var order = this.orderRepository.save(orderMapper.toOrder(request));

        // persist order lines
        for(PurchaseRequest purchaseRequest: request.products()){
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
        }

        //start payment process
        var paymentRequest = new PaymentRequest(
                request.amount(),
                request.paymentMethod(),
                order.getId(),
                order.getReference(),
                customer
        );

        paymentClient.requestOrderPayment(paymentRequest);


        // send the order confirmation --> notification-ms (kafka)
        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        request.reference(),
                        request.amount(),
                        request.paymentMethod(),
                        customer,
                        purchasedProducts
                )
        );

        return order.getId();
    }

    public List<OrderResponse> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::fromOrder)
                .collect(Collectors.toList());
    }

    public OrderResponse findById(Integer orderId) {
        return orderRepository.findById(orderId)
                .map(orderMapper::fromOrder)
                .orElseThrow(() -> new EntityNotFoundException("No order found for the ID."+orderId));
    }
}
