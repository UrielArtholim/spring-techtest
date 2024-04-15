package com.bcnc.techtest.services;

import com.bcnc.techtest.domain.models.Product;
import com.bcnc.techtest.domain.ports.in.CreateProductUseCase;
import com.bcnc.techtest.domain.ports.in.DeleteProductUseCase;
import com.bcnc.techtest.domain.ports.in.RetrieveProductUseCase;
import com.bcnc.techtest.domain.ports.in.UpdateProductUseCase;
import com.bcnc.techtest.usecases.CreateProductUseCaseImpl;
import com.bcnc.techtest.usecases.DeleteProductUseCaseImpl;
import com.bcnc.techtest.usecases.RetrieveProductUseCaseImpl;
import com.bcnc.techtest.usecases.UpdateProductUseCaseImpl;
import org.springframework.stereotype.Service;

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
    public Product retrieveProduct(long brandId, long productId, LocalDateTime date) {
        return this.retrieveProductUseCase.retrieveProduct(brandId, productId, date);
    }


    @Override
    public void updateProduct(long brandId, long productId, LocalDateTime date, Product product) {
        this.updateProductUseCase.updateProduct(brandId, productId, date, product);
    }

    @Override
    public void deleteProduct(long brandId, long productId, LocalDateTime date) {
        this.deleteProductUseCase.deleteProduct(brandId, productId, date);
    }

}
