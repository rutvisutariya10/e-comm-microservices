package com.ppa.ecomm.repository;

import com.ppa.ecomm.entity.OrderLine;
import com.ppa.ecomm.records.OrderLineResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLine,Integer> {
    List<OrderLine> findAllByOrderId(Integer orderId);
}
