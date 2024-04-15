package com.bcnc.techtest.domain.ports.out;

import com.bcnc.techtest.domain.models.Product;
import com.bcnc.techtest.domain.models.ProductInfo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface ProductRepositoryPort {
    void createProduct(Product product);

    ProductInfo retrieveProduct(BigDecimal brandId, BigDecimal productId, LocalDateTime date);

    void updateProduct(BigDecimal brandId, BigDecimal productId, LocalDateTime date, Product product);

    void deleteProduct(BigDecimal brandId, BigDecimal productId, LocalDateTime date);
}
