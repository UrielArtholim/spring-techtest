package com.example.techtest.domain.ports.in;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface DeleteProductUseCase {
    void deleteProduct(BigDecimal brandId, BigDecimal productId, LocalDateTime date);
}
