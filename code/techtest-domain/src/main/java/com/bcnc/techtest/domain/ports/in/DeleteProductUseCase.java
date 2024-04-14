package com.bcnc.techtest.domain.ports.in;

import java.time.LocalDateTime;

public interface DeleteProductUseCase {
    void deleteProduct(long brandId, long productId, LocalDateTime date);
}
