package com.bcnc.techtest.usecases;

import com.bcnc.techtest.domain.ports.in.DeleteProductUseCase;
import com.bcnc.techtest.domain.ports.out.ProductRepositoryPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class DeleteProductUseCaseImpl implements DeleteProductUseCase {

    private final ProductRepositoryPort repository;

    public DeleteProductUseCaseImpl(final ProductRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public void deleteProduct(long brandId, long productId, LocalDateTime date) {
        this.repository.deleteProduct(brandId, productId, date);
        log.debug("|- Use Case: Delete Product -| ");
        log.debug("|- Status: COMPLETE -|");
    }
}
