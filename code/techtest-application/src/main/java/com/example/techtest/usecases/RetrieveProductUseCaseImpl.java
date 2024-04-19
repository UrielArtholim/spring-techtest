package com.example.techtest.usecases;

import com.example.techtest.domain.models.ProductInfo;
import com.example.techtest.domain.ports.in.RetrieveProductUseCase;
import com.example.techtest.domain.ports.out.IProductRepositoryAdapter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class RetrieveProductUseCaseImpl implements RetrieveProductUseCase {
    private final IProductRepositoryAdapter repository;

    public RetrieveProductUseCaseImpl(final IProductRepositoryAdapter repository) {
        this.repository = repository;
    }

    @Override
    public ProductInfo retrieveProduct(BigDecimal brandId, BigDecimal productId, LocalDateTime date) {
        ProductInfo productInfo = this.repository.retrieveProduct(brandId, productId, date);
        return productInfo;
    }
}
