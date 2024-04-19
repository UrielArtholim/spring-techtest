package com.example.techtest.usecases;

import com.example.techtest.domain.models.Product;
import com.example.techtest.domain.ports.in.UpdateProductUseCase;
import com.example.techtest.domain.ports.out.IProductRepositoryAdapter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class UpdateProductUseCaseImpl implements UpdateProductUseCase {
    private final IProductRepositoryAdapter repository;

    public UpdateProductUseCaseImpl(final IProductRepositoryAdapter repository) {
        this.repository = repository;
    }

    @Override
    public void updateProduct(BigDecimal brandId, BigDecimal productId, LocalDateTime date, Product product) {
        this.repository.updateProduct(brandId, productId, date, product);
    }
}
