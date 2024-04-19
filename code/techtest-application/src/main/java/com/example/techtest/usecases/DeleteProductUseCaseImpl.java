package com.example.techtest.usecases;

import com.example.techtest.domain.ports.in.DeleteProductUseCase;
import com.example.techtest.domain.ports.out.IProductRepositoryAdapter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class DeleteProductUseCaseImpl implements DeleteProductUseCase {

    private final IProductRepositoryAdapter repository;

    public DeleteProductUseCaseImpl(final IProductRepositoryAdapter repository) {
        this.repository = repository;
    }

    @Override
    public void deleteProduct(BigDecimal brandId, BigDecimal productId, LocalDateTime date) {
        this.repository.deleteProduct(brandId, productId, date);

    }
}
