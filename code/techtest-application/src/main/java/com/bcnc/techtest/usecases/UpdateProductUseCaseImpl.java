package com.bcnc.techtest.usecases;

import com.bcnc.techtest.domain.models.Product;
import com.bcnc.techtest.domain.ports.in.UpdateProductUseCase;
import com.bcnc.techtest.domain.ports.out.ProductRepositoryPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class UpdateProductUseCaseImpl implements UpdateProductUseCase {
    private final ProductRepositoryPort repository;

    public UpdateProductUseCaseImpl(final ProductRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public void updateProduct(long brandId, long productId, LocalDateTime date, Product product) {
        this.repository.updateProduct(brandId, productId, date, product);
        log.debug("|- Use Case: Update Product -| ");
        log.debug("|- Status: COMPLETE -|");
    }
}
