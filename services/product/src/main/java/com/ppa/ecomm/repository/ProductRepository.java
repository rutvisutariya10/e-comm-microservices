package com.ppa.ecomm.repository;


import com.ppa.ecomm.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByIdInOrderById(List<Integer> productIds);
}
