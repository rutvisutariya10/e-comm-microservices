package com.ppa.ecomm.controller;


import com.ppa.ecomm.records.ProductPurchaseRequest;
import com.ppa.ecomm.records.ProductPurchaseResponse;
import com.ppa.ecomm.records.ProductRequest;
import com.ppa.ecomm.records.ProductResponse;
import com.ppa.ecomm.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Integer> createProduct (
            @RequestBody @Valid ProductRequest request
    ){
        return ResponseEntity.ok(productService.createProduct(request));
    }

    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>> purchaseProducts(
            @RequestBody List<ProductPurchaseRequest> request
    ){
        return ResponseEntity.ok(productService.purchaseProducts(request));
    }

    @GetMapping("/{product_id}")
    public ResponseEntity<ProductResponse> findById(
            @PathVariable("product_id") Integer productId
    ) {
        return ResponseEntity.ok(productService.findProductById(productId));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAllProducts(){
        return ResponseEntity.ok(productService.findAllProducts());
    }
}
