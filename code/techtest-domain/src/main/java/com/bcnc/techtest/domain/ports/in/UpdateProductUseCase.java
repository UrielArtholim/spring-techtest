package com.bcnc.techtest.domain.ports.in;

import com.bcnc.techtest.domain.models.Product;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface UpdateProductUseCase {
    void updateProduct(BigDecimal brandId, BigDecimal productId, LocalDateTime date, Product product);
}

