package com.example.techtest.data.adapters;

import com.example.techtest.data.entities.ProductEntity;
import com.example.techtest.data.mappers.ProductEntityMapper;
import com.example.techtest.data.repositories.ProductRepository;
import com.example.techtest.domain.models.Product;
import com.example.techtest.domain.models.ProductInfo;
import com.example.techtest.domain.ports.out.IProductRepositoryAdapter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class ProductRepositoryAdapterImpl implements IProductRepositoryAdapter {

    @PersistenceContext
    private final EntityManager entityManager;
    private final ProductRepository repository;
    private final ProductEntityMapper mapper;


    public ProductRepositoryAdapterImpl(final EntityManager entityManager,
                                        final ProductRepository repository,
                                        final ProductEntityMapper mapper) {
        this.entityManager = entityManager;
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Product createProduct(Product product) {
        if (this.retrieveProduct(product.getBrandId(), product.getProductId(), product.getStartDate()) == null) {
            ProductEntity productEntity = this.mapper.toProductEntity(product);
            this.repository.saveAndFlush(productEntity);
            return this.mapper.toProduct(productEntity);
        }
        return null;
    }

    @Override
    public ProductInfo retrieveProduct(BigDecimal brandId, BigDecimal productId, LocalDateTime date) {
        ProductEntity productEntity = this.repository.findProduct(brandId, productId, date);
        return productEntity == null ? null : this.mapper.toProductInfo(productEntity);
    }

    @Override
    @Transactional
    public void updateProduct(BigDecimal brandId, BigDecimal productId, LocalDateTime date, Product product) {
        ProductEntity updatedProduct = this.mapper.toProductEntity(product);
        ProductEntity productToUpdate = this.repository.findProduct(brandId, productId, date);
        if (updatedProduct != null) {
            if (productToUpdate != null) {
                if (!productToUpdate.equals(updatedProduct)) {
                    this.repository.saveAndFlush(updatedProduct);
                }
            } else {
                this.createProduct(product);
            }
        }
    }

    @Override
    @Transactional
    public void deleteProduct(BigDecimal brandId, BigDecimal productId, LocalDateTime date) {
        if (this.retrieveProduct(brandId, productId, date) != null)
            this.repository.deleteProduct(brandId, productId, date);
    }

}
