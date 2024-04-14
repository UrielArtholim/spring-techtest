package com.bcnc.techtest.domain.ports.in;

import com.bcnc.techtest.domain.models.Product;

import java.time.LocalDateTime;

public interface UpdateProductUseCase {
    void updateProduct(Long brandId, Long productId, LocalDateTime date, Product product);
}

