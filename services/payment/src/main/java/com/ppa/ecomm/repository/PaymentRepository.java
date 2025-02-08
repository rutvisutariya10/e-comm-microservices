package com.ppa.ecomm.repository;

import com.ppa.ecomm.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
