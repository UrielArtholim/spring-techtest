package com.example.techtest.usecases;

import com.example.techtest.domain.models.Product;
import com.example.techtest.domain.models.ProductInfo;
import com.example.techtest.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Unit tests for {@link ProductService}
 */
@SpringBootTest(classes = ProductService.class)
class ProductServiceTest {

    @MockBean
    private CreateProductUseCaseImpl createProductUseCase;

    @MockBean
    private RetrieveProductUseCaseImpl retrieveProductUseCase;

    @MockBean
    private UpdateProductUseCaseImpl updateProductUseCase;

    @MockBean
    private DeleteProductUseCaseImpl deleteProductUseCase;

    private ProductService productService;

    @BeforeEach
    void setUp() {
        this.productService = new ProductService(this.createProductUseCase,
          this.retrieveProductUseCase,
          this.updateProductUseCase,
          this.deleteProductUseCase);
    }

    @Test
    void createProduct_unitTest_OK() {
        Product product = this.setUpProduct();
        this.productService.createProduct(product);
        verify(this.createProductUseCase).createProduct(any());
    }

    @Test
    void retrieveProduct_unitTest_OK() {
        BigDecimal productId = BigDecimal.valueOf(35455);
        BigDecimal brandId = BigDecimal.valueOf(1);
        LocalDateTime date = LocalDateTime.parse("2020-06-14T00:00:00");
        ProductInfo productInfo = this.setUpProductInfo();
        when(this.retrieveProductUseCase.retrieveProduct(any(), any(), any())).thenReturn(productInfo);
        this.productService.retrieveProduct(brandId, productId, date);
        verify(this.retrieveProductUseCase).retrieveProduct(brandId, productId, date);
    }

    @Test
    void updateProduct_unitTest_OK() {
        BigDecimal productId = BigDecimal.valueOf(35455);
        BigDecimal brandId = BigDecimal.valueOf(1);
        LocalDateTime date = LocalDateTime.parse("2020-06-14T00:00:00");
        Product product = this.setUpProduct();
        this.productService.updateProduct(brandId, productId, date, product);
        verify(this.updateProductUseCase).updateProduct(brandId, productId, date, product);
    }

    @Test
    void deleteProduct_unitTest_OK() {
        BigDecimal productId = BigDecimal.valueOf(35455);
        BigDecimal brandId = BigDecimal.valueOf(1);
        LocalDateTime date = LocalDateTime.parse("2020-06-14T00:00:00");
        this.productService.deleteProduct(brandId, productId, date);
        verify(this.deleteProductUseCase).deleteProduct(brandId, productId, date);
    }

    private Product setUpProduct() {
        BigDecimal productId = BigDecimal.valueOf(35455);
        BigDecimal brandId = BigDecimal.valueOf(1);
        int priceList = 1;
        int priority = 0;
        BigDecimal price = BigDecimal.valueOf(15.50);
        String currency = "EUR";
        LocalDateTime startDate = LocalDateTime.parse("2020-06-14T00:00:00");
        LocalDateTime endDate = LocalDateTime.parse("2020-12-31T23:59:59");
        return new Product(brandId, productId, priceList, price, currency, startDate, endDate, priority);

    }

    private ProductInfo setUpProductInfo() {
        BigDecimal productId = BigDecimal.valueOf(35455);
        BigDecimal brandId = BigDecimal.valueOf(1);
        int priceList = 1;
        BigDecimal price = BigDecimal.valueOf(15.50);
        String currency = "EUR";
        LocalDateTime startDate = LocalDateTime.parse("2020-06-14T00:00:00");
        LocalDateTime endDate = LocalDateTime.parse("2020-12-31T23:59:59");
        return new ProductInfo(brandId, productId, priceList,  price, currency, startDate, endDate);
    }
}
