package com.bcnc.techtest.domain.ports.out;

import com.bcnc.techtest.domain.models.Product;

import java.time.LocalDateTime;

public interface ProductRepositoryPort {
    void createProduct(Product product);

    Product retrieveProduct(long brandId, long productId, LocalDateTime date);

    void updateProduct(long brandId, long productId, LocalDateTime date, Product product);

    void deleteProduct(long brandId, long productId, LocalDateTime date);
}
