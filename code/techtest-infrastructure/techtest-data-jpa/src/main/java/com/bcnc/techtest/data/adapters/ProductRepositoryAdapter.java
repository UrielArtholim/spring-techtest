package com.bcnc.techtest.data.adapters;

import com.bcnc.techtest.data.entities.ProductEntity;
import com.bcnc.techtest.data.mappers.ProductEntityMapper;
import com.bcnc.techtest.data.mappers.ProductInfoMappper;
import com.bcnc.techtest.data.repositories.ProductRepository;
import com.bcnc.techtest.domain.models.Product;
import com.bcnc.techtest.domain.models.ProductInfo;
import com.bcnc.techtest.domain.ports.out.ProductRepositoryPort;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class ProductRepositoryAdapter implements ProductRepositoryPort {

    @PersistenceContext
    private final EntityManager entityManager;
    private final ProductRepository repository;
    private final ProductEntityMapper productEntityMapper;
    private final ProductInfoMappper productInfoMappper;


    public ProductRepositoryAdapter(final EntityManager entityManager,
                                    final ProductRepository repository,
                                    final ProductEntityMapper productEntityMapper,
                                    final ProductInfoMappper productInfoMappper) {
        this.entityManager = entityManager;
        this.repository = repository;
        this.productEntityMapper = productEntityMapper;
        this.productInfoMappper = productInfoMappper;
    }

    @Override
    public void createProduct(Product product) {
        if (this.retrieveProduct(product) == null)
            this.repository.saveAndFlush(this.productEntityMapper.toProductEntity(product));
    }

    @Override
    public ProductInfo retrieveProduct(BigDecimal brandId, BigDecimal productId, LocalDateTime date) {
        ProductEntity productEntity = this.repository.findProduct(brandId, productId, date);
        return productEntity == null ? null : this.productInfoMappper.toProductInfo(productEntity);
    }

    @Override
    public void updateProduct(BigDecimal brandId, BigDecimal productId, LocalDateTime date, Product product) {
        ProductEntity productToUpdate = this.repository.findProduct(brandId, productId, date);
        if (productToUpdate != null && product != null) {
            productToUpdate.setPriceList(!Objects.equals(productToUpdate.getPriceList(), product.getPriceList()) ? product.getPriceList() : productToUpdate.getPriceList());
            productToUpdate.setPriority(!Objects.equals(productToUpdate.getPriority(), product.getPriority()) ? product.getPriority() : productToUpdate.getPriority());
            productToUpdate.setPrice(!Objects.equals(productToUpdate.getPrice(), product.getPrice()) ? product.getPrice() : productToUpdate.getPrice());
            productToUpdate.setCurrency(!Objects.equals(productToUpdate.getCurrency(), product.getCurrency()) ? product.getCurrency() : productToUpdate.getCurrency());
            productToUpdate.setStartDate(!Objects.equals(productToUpdate.getStartDate(), product.getStartDate()) ? product.getStartDate() : productToUpdate.getStartDate());
            productToUpdate.setEndDate(!Objects.equals(productToUpdate.getEndDate(), product.getEndDate()) ? product.getEndDate() : productToUpdate.getEndDate());
            this.repository.saveAndFlush(productToUpdate);
        }
        else if(productToUpdate == null && product != null)
        {
            this.createProduct(product);
        }
    }

    @Override
    public void deleteProduct(BigDecimal brandId, BigDecimal productId, LocalDateTime date) {
        if (this.retrieveProduct(brandId, productId, date) != null)
            this.repository.deleteProduct(brandId, productId, date);
    }

    private ProductInfo retrieveProduct(Product product) {
        return this.retrieveProduct(product.getBrandId(), product.getProductId(), product.getStartDate());
    }

}
