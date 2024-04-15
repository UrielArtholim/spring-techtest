package com.bcnc.techtest.rest.controllers;

import com.bcnc.techtest.domain.models.Product;
import com.bcnc.techtest.model.ProductDTO;
import com.bcnc.techtest.rest.controller.ProductController;
import com.bcnc.techtest.rest.mappers.ProductDTOMapper;
import com.bcnc.techtest.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = ProductController.class)
class ProductControllerTest {

    @MockBean
    private ProductService productService;

    @MockBean
    private ProductDTOMapper mapper;

    private ProductController controller;

    @BeforeEach
    void SetUp() {
        this.controller = new ProductController(productService, mapper);
    }

    @Test
    void createProductTest_OK() {
        int productId = 35455;
        int brandId = 1;
        ProductDTO newProductDTO = this.setUpProductDTO();
        when(this.productService.retrieveProduct(anyInt(), anyInt(), any())).thenReturn(null);
        ResponseEntity<ProductDTO> response = this.controller.createProduct(newProductDTO);
        assertEquals(ResponseEntity.ok(newProductDTO), response);
    }

    @Test
    void createProductTest_CONFLICT() {
        int productId = 35455;
        int brandId = 1;
        ProductDTO newProductDTO = this.setUpProductDTO();
        Product newProduct = this.setUpProduct();
        when(this.productService.retrieveProduct(anyInt(), anyInt(), any())).thenReturn(newProduct);
        ResponseEntity<ProductDTO> response = this.controller.createProduct(newProductDTO);
        assertEquals(new ResponseEntity<>(HttpStatus.CONFLICT), response);
    }

    @Test
    void retrieveProductTest_OK() {
        int productId = 35455;
        int brandId = 1;
        String date = "2020-06-14T00:00:00";
        ProductDTO productDTO = this.setUpProductDTO();
        Product product =this.setUpProduct();
        when(this.productService.retrieveProduct(anyInt(), anyInt(), any())).thenReturn(product);
        ResponseEntity<ProductDTO> response = this.controller.getProduct(productId, brandId, date);
        assertEquals(ResponseEntity.ok(productDTO), response);
    }

    @Test
    void retrieveProductTest_NOT_FOUND() {
        int productId = 35455;
        int brandId = 1;
        String date = "2020-06-14T00:00:00";
        when(this.productService.retrieveProduct(anyInt(), anyInt(), any())).thenReturn(null);
        ResponseEntity<ProductDTO> response = this.controller.getProduct(productId, brandId, date);
        assertEquals(ResponseEntity.notFound().build(), response);
    }

    @Test
    void updateProductTest_OK() {
        int productId = 35455;
        int brandId = 1;
        String date = "2020-06-14T00:00:00";
        ProductDTO productDTO = this.setUpProductDTO();
        Product product =this.setUpProduct();
        when(this.productService.retrieveProduct(anyInt(), anyInt(), any())).thenReturn(product);
        ResponseEntity<ProductDTO> response = this.controller.updateProduct(productId, brandId, date, productDTO);
        assertEquals(ResponseEntity.ok(productDTO), response);
    }

    @Test
    void updateProductTest_NO_CONTENT() {
        int productId = 35455;
        int brandId = 1;
        String date = "2020-06-14T00:00:00";
        ProductDTO productDTO = this.setUpProductDTO();
        Product product =this.setUpProduct();
        when(this.productService.retrieveProduct(anyInt(), anyInt(), any())).thenReturn(product);
        ResponseEntity<ProductDTO> response = this.controller.updateProduct(productId, brandId, date, productDTO);
        assertEquals(ResponseEntity.noContent().build(), response);
    }


    @Test
    void deleteProductTest_NO_CONTENT() {
        int productId = 35455;
        int brandId = 1;
        String date = "2020-06-14T00:00:00";
        Product product = this.setUpProduct();
        when(this.productService.retrieveProduct(anyInt(), anyInt(), any())).thenReturn(product);
        ResponseEntity<ProductDTO> response = this.controller.deleteProduct(productId, brandId, date);
        assertEquals(ResponseEntity.noContent().build(), response);
    }

    @Test
    void deleteProductTest_NOT_FOUND() {
        int productId = 35455;
        int brandId = 1;
        String date = "2020-06-14T00:00:00";
        when(this.productService.retrieveProduct(anyInt(), anyInt(), any())).thenReturn(null);
        ResponseEntity<ProductDTO> response = this.controller.deleteProduct(productId, brandId, date);
        assertEquals(ResponseEntity.notFound().build(), response);
    }


    private Product setUpProduct() {
        int brandId = 1;
        int productId = 35455;
        int productList = 1;
        int priority = 0;
        BigDecimal price = BigDecimal.valueOf(15.50);
        String currency = "EUR";
        LocalDateTime startDate = LocalDateTime.parse("2020-06-14T00:00:00");
        LocalDateTime endDate = LocalDateTime.parse("2020-12-31T23:59:59");
        return new Product(brandId,productId, productList, priority, price, currency, startDate, endDate);
    }

    private ProductDTO setUpProductDTO() {
        ProductDTO product = new ProductDTO();
        product.setBrandId(1);
        product.setProductId(35455);
        product.setProductList(1);
        product.setPriority(0);
        product.setPrice(BigDecimal.valueOf(15.50));
        product.setCurrency("EUR");
        product.setStartDate("2020-06-14T00:00:00");
        product.setEndDate("2020-12-31T23:59:59");
        return new ProductDTO();
    }

}
