package com.example.techtest.domain.ports.in;

import com.example.techtest.domain.models.Product;

public interface CreateProductUseCase {
    Product createProduct(Product product);
}
