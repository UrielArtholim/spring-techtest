package com.bcnc.techtest.domain.ports.in;

import com.bcnc.techtest.domain.models.Product;

import java.time.LocalDateTime;

public interface RetrieveProductUseCase {
    Product retrieveProduct(long brandId, long productId, LocalDateTime date);
}
