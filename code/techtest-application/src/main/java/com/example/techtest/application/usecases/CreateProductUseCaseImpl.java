package com.example.techtest.application.usecases;

import com.example.techtest.domain.models.Product;
import com.example.techtest.domain.ports.in.CreateProductUseCase;
import com.example.techtest.domain.ports.out.IProductRepositoryAdapter;
import org.springframework.stereotype.Component;

@Component
public class CreateProductUseCaseImpl implements CreateProductUseCase {

    private final IProductRepositoryAdapter repository;

    public CreateProductUseCaseImpl(final IProductRepositoryAdapter repository) {

        this.repository = repository;
    }

    @Override
    public Product createProduct(Product product) {
        return this.repository.createProduct(product);

    }
}
