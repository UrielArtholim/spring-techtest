package com.bcnc.techtest.usecases;

import com.bcnc.techtest.domain.models.Product;
import com.bcnc.techtest.domain.ports.in.CreateProductUseCase;
import com.bcnc.techtest.domain.ports.out.ProductRepositoryPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CreateProductUseCaseImpl implements CreateProductUseCase {

    private final ProductRepositoryPort repository;

    public CreateProductUseCaseImpl(final ProductRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public void createProduct(Product product) {
        this.repository.createProduct(product);
        log.debug("|- Use Case: Create Product -| ");
        log.debug("|- Status: COMPLETE -|");
    }
}
