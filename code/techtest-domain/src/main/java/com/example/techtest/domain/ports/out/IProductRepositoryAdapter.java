package com.example.techtest.domain.ports.out;

import com.example.techtest.domain.models.Product;
import com.example.techtest.domain.models.ProductInfo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public interface IProductRepositoryAdapter {
    void createProduct(Product product);

    ProductInfo retrieveProduct(BigDecimal brandId, BigDecimal productId, LocalDateTime date);

    void updateProduct(BigDecimal brandId, BigDecimal productId, LocalDateTime date, Product product);

    void deleteProduct(BigDecimal brandId, BigDecimal productId, LocalDateTime date);
}
