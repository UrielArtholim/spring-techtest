package com.example.techtest.services;

import com.example.techtest.domain.models.Product;
import com.example.techtest.domain.models.ProductInfo;
import com.example.techtest.domain.ports.in.CreateProductUseCase;
import com.example.techtest.domain.ports.in.DeleteProductUseCase;
import com.example.techtest.domain.ports.in.RetrieveProductUseCase;
import com.example.techtest.domain.ports.in.UpdateProductUseCase;
import com.example.techtest.usecases.CreateProductUseCaseImpl;
import com.example.techtest.usecases.DeleteProductUseCaseImpl;
import com.example.techtest.usecases.RetrieveProductUseCaseImpl;
import com.example.techtest.usecases.UpdateProductUseCaseImpl;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class ProductService implements CreateProductUseCase, RetrieveProductUseCase, UpdateProductUseCase, DeleteProductUseCase {

    private final CreateProductUseCaseImpl createProductUseCase;
    private final RetrieveProductUseCaseImpl retrieveProductUseCase;
    private final UpdateProductUseCaseImpl updateProductUseCase;
    private final DeleteProductUseCaseImpl deleteProductUseCase;

    public ProductService(final CreateProductUseCaseImpl createProductUseCase,
                          final RetrieveProductUseCaseImpl retrieveProductUseCase,
                          final UpdateProductUseCaseImpl updateProductUseCase,
                          final DeleteProductUseCaseImpl deleteProductUseCase) {
        this.createProductUseCase = createProductUseCase;
        this.retrieveProductUseCase = retrieveProductUseCase;
        this.updateProductUseCase = updateProductUseCase;
        this.deleteProductUseCase = deleteProductUseCase;
    }

    @Override
    public void createProduct(Product product) {
        this.createProductUseCase.createProduct(product);
    }

    @Override
    public ProductInfo retrieveProduct(BigDecimal brandId, BigDecimal productId, LocalDateTime date) {
        return this.retrieveProductUseCase.retrieveProduct(brandId, productId, date);
    }


    @Override
    public void updateProduct(BigDecimal brandId, BigDecimal productId, LocalDateTime date, Product product) {
        this.updateProductUseCase.updateProduct(brandId, productId, date, product);
    }

    @Override
    public void deleteProduct(BigDecimal brandId, BigDecimal productId, LocalDateTime date) {
        this.deleteProductUseCase.deleteProduct(brandId, productId, date);
    }

}
