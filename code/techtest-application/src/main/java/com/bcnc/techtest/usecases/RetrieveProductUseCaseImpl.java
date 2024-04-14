package com.bcnc.techtest.usecases;

import com.bcnc.techtest.domain.models.Product;
import com.bcnc.techtest.domain.ports.in.RetrieveProductUseCase;
import com.bcnc.techtest.domain.ports.out.ProductRepositoryPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class RetrieveProductUseCaseImpl implements RetrieveProductUseCase {
    private final ProductRepositoryPort repository;

    public RetrieveProductUseCaseImpl(final ProductRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Product retrieveProduct(long brandId, long productId, LocalDateTime date) {
        Product retrievedProduct = this.repository.retrieveProduct(brandId, productId, date);
        log.debug("|- Use Case: Retrieve Product -| ");
        log.debug("|- Status: COMPLETE -|");
        return retrievedProduct;
    }
}
