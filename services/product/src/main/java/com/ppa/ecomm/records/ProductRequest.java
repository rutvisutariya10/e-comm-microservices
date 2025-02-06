package com.ppa.ecomm.records;

import com.ppa.ecomm.entity.category.Category;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequest(
        Integer id,
        @NotNull(message = "Product Name Required.")
        String name,
        @NotNull(message = "Product Description Required.")
        String description,
        @Positive(message = "Available Quantity should be Positive.")
        double availableQuantity,
        @Positive(message = "Available Quantity should be Positive.")
        BigDecimal price,
        @NotNull(message = "Product Category Required.")
        Integer categoryId
) {
}
