package com.example.techtest.usecases;

import com.example.techtest.domain.models.Product;
import com.example.techtest.domain.ports.in.CreateProductUseCase;
import com.example.techtest.domain.ports.out.IProductRepositoryAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CreateProductUseCaseImpl implements CreateProductUseCase {

    private final IProductRepositoryAdapter repository;

    public CreateProductUseCaseImpl(final IProductRepositoryAdapter repository) {

        this.repository = repository;
    }

    @Override
    public void createProduct(Product product) {
        this.repository.createProduct(product);
        log.debug("|- Use Case: Create Product -| ");
        log.debug("|- Status: COMPLETE -|");
    }
}
