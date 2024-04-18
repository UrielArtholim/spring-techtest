package com.example.techtest.domain.ports.in;

import com.example.techtest.domain.models.ProductInfo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface RetrieveProductUseCase {
    ProductInfo retrieveProduct(BigDecimal brandId, BigDecimal productId, LocalDateTime date);
}
