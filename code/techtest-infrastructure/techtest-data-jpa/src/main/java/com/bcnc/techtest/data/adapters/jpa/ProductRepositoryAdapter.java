package com.bcnc.techtest.data.adapters.jpa;

import com.bcnc.techtest.data.entities.ProductEntity;
import com.bcnc.techtest.data.mappers.ProductEntityMapper;
import com.bcnc.techtest.data.repositories.jpa.ProductRepository;
import com.bcnc.techtest.domain.models.Product;
import com.bcnc.techtest.domain.ports.out.ProductRepositoryPort;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class ProductRepositoryAdapter implements ProductRepositoryPort {

    @PersistenceContext
    private final EntityManager entityManager;
    private final ProductRepository repository;
    private final ProductEntityMapper mapper;

    public ProductRepositoryAdapter(final EntityManager entityManager, final ProductRepository repository, final ProductEntityMapper mapper) {
        this.entityManager = entityManager;
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void createProduct(Product product) {
        if (this.retrieveProduct(product) == null)
            this.repository.saveAndFlush(this.mapper.toProductEntity(product));
    }

    @Override
    public Product retrieveProduct(long brandId, long productId, LocalDateTime date) {
        ProductEntity productEntity = this.repository.findProduct(brandId, productId, date);
        return this.mapper.toProduct(productEntity);
    }

    @Override
    public void updateProduct(long brandId, long productId, LocalDateTime date, Product product) {
        ProductEntity productToUpdate = this.repository.findProduct(brandId, productId, date);
        if (productToUpdate != null) {
            productToUpdate.setProductList(!Objects.equals(productToUpdate.getProductList(), product.getProductList()) ? product.getProductList() : productToUpdate.getProductList());
            productToUpdate.setPriority(!Objects.equals(productToUpdate.getPriority(), product.getPriority()) ? product.getPriority() : productToUpdate.getPriority());
            productToUpdate.setPrice(!Objects.equals(productToUpdate.getPrice(), product.getPrice()) ? product.getPrice() : productToUpdate.getPrice());
            productToUpdate.setCurrency(!Objects.equals(productToUpdate.getCurrency(), product.getCurrency()) ? product.getCurrency() : productToUpdate.getCurrency());
            productToUpdate.setStartDate(!Objects.equals(productToUpdate.getStartDate(), product.getStartDate()) ? product.getStartDate() : productToUpdate.getStartDate());
            productToUpdate.setEndDate(!Objects.equals(productToUpdate.getEndDate(), product.getEndDate()) ? product.getEndDate() : productToUpdate.getEndDate());
            this.repository.saveAndFlush(productToUpdate);
        }
    }

    @Override
    public void deleteProduct(long brandId, long productId, LocalDateTime date) {
        if (this.retrieveProduct(brandId, productId, date) != null)
            this.repository.deleteProduct(brandId, productId, date);
    }

    private Product retrieveProduct(Product product) {
        return this.retrieveProduct(product.getBrandId(), product.getProductId(), product.getStartDate());
    }

}
