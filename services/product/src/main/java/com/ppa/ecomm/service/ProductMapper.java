package com.ppa.ecomm.service;

import com.ppa.ecomm.entity.category.Category;
import com.ppa.ecomm.entity.product.Product;
import com.ppa.ecomm.records.ProductPurchaseResponse;
import com.ppa.ecomm.records.ProductRequest;
import com.ppa.ecomm.records.ProductResponse;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    public Product toProduct(ProductRequest request){
        return Product.builder()
                .id(request.id())
                .name(request.name())
                .description(request.name())
                .availableQuantity(request.availableQuantity())
                .price(request.price())
                .category(
                        Category.builder()
                        .id(request.categoryId())
                        .build())
                .build();
    }

    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getAvailableQuantity(),
                product.getPrice(),
                product.getCategory().getId(),
                product.getCategory().getName(),
                product.getCategory().getDescription()
        );
    }

    public ProductPurchaseResponse toProductPurchaseResponse(Product product, double quantity) {
        return new ProductPurchaseResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                quantity
        );
    }
}
