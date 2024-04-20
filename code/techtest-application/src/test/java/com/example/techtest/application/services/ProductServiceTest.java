package com.example.techtest.application.services;

import com.example.techtest.application.usecases.CreateProductUseCaseImpl;
import com.example.techtest.application.usecases.DeleteProductUseCaseImpl;
import com.example.techtest.application.usecases.RetrieveProductUseCaseImpl;
import com.example.techtest.application.usecases.UpdateProductUseCaseImpl;
import com.example.techtest.domain.models.Product;
import com.example.techtest.domain.models.ProductInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = ProductService.class )
class ProductServiceTest {

    @MockBean
    private CreateProductUseCaseImpl createProductUseCase;

    @MockBean
    private RetrieveProductUseCaseImpl retrieveProductUseCase;
    @MockBean
    private UpdateProductUseCaseImpl updateProductUseCase;
    @MockBean
    private DeleteProductUseCaseImpl deleteProductUseCase;

    private ProductService service;

    @BeforeEach
    void setUp()
    {
        this.service = new ProductService(this.createProductUseCase, this.retrieveProductUseCase, this.updateProductUseCase, this.deleteProductUseCase);
    }

    @Test
    void createProduct()
    {
        Product product = this.setUpProduct();
        when(this.createProductUseCase.createProduct(any())).thenReturn(this.setUpProduct());
        Product response = this.service.createProduct(product);
        verify(this.createProductUseCase).createProduct(any());
        assertNotNull(response);
        assertEquals(product, response);
    }

    @Test
    void retrieveProduct()
    {
        BigDecimal brandId = BigDecimal.valueOf(1);
        BigDecimal productId = BigDecimal.valueOf(1);
        LocalDateTime date = LocalDateTime.parse("2020-06-14T00:00:00");
        ProductInfo expectedResponse = this.setUpProductInfo();
        when(this.retrieveProductUseCase.retrieveProduct(any(), any(), any())).thenReturn(this.setUpProductInfo());
        ProductInfo response = this.service.retrieveProduct(brandId, productId, date);
        verify(this.retrieveProductUseCase).retrieveProduct(any(), any(), any());
        assertNotNull(response);
        assertEquals(expectedResponse, response);
    }

    @Test
    void updateProduct()
    {
        BigDecimal brandId = BigDecimal.valueOf(1);
        BigDecimal productId = BigDecimal.valueOf(1);
        LocalDateTime date = LocalDateTime.parse("2020-06-14T00:00:00");
        Product product = this.setUpProduct();
        ProductInfo expectedResponse = this.setUpProductInfo();
        this.service.updateProduct(brandId, productId, date, product);
        verify(this.updateProductUseCase).updateProduct(any(), any(), any(), any());
    }

    @Test
    void deleteProduct()
    {
        BigDecimal brandId = BigDecimal.valueOf(1);
        BigDecimal productId = BigDecimal.valueOf(1);
        LocalDateTime date = LocalDateTime.parse("2020-06-14T00:00:00");
        this.service.deleteProduct(brandId, productId, date);
        verify(this.deleteProductUseCase).deleteProduct(any(), any(), any());
    }

    private Product setUpProduct() {
        return Product.builder()
          .productId(BigDecimal.valueOf(1))
          .brandId(BigDecimal.valueOf(1))
          .priceList(1)
          .startDate(LocalDateTime.parse("2020-06-14T00:00:00"))
          .endDate(LocalDateTime.parse("2020-12-31T23:59:59"))
          .price(BigDecimal.valueOf(10.00))
          .currency("EUR")
          .build();
    }

    private ProductInfo setUpProductInfo() {
        return ProductInfo.builder()
          .productId(BigDecimal.valueOf(1))
          .brandId(BigDecimal.valueOf(1))
          .priceList(1)
          .startDate(LocalDateTime.parse("2020-06-14T00:00:00"))
          .endDate(LocalDateTime.parse("2020-12-31T23:59:59"))
          .price(BigDecimal.valueOf(10.00))
          .currency("EUR")
          .build();
    }
}
