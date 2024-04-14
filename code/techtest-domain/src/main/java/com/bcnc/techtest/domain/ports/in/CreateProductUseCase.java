package com.bcnc.techtest.domain.ports.in;

import com.bcnc.techtest.domain.models.Product;

public interface CreateProductUseCase {
    void createProduct(Product product);
}
