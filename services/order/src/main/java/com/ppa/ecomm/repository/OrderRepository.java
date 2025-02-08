package com.ppa.ecomm.repository;

import com.ppa.ecomm.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
