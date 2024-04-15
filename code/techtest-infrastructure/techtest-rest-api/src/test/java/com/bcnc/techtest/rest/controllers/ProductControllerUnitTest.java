package com.bcnc.techtest.rest.controllers;

import com.bcnc.techtest.domain.models.Product;
import com.bcnc.techtest.domain.models.ProductInfo;
import com.bcnc.techtest.model.ProductDTO;
import com.bcnc.techtest.model.ProductInfoDTO;
import com.bcnc.techtest.rest.controller.ProductController;
import com.bcnc.techtest.rest.mappers.ProductDTOMapper;
import com.bcnc.techtest.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = ProductController.class)
class ProductControllerUnitTest {

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
        BigDecimal productId = BigDecimal.valueOf(35455);
        BigDecimal brandId = BigDecimal.valueOf(1);
        ProductDTO newProductDTO = this.setUpProductDTO();
        when(this.productService.retrieveProduct(any(), any(), any())).thenReturn(null);
        ResponseEntity<ProductDTO> response = this.controller.createProduct(newProductDTO);
        assertEquals(ResponseEntity.ok(newProductDTO), response);
    }

    @Test
    void createProductTest_CONFLICT() {
        ProductDTO newProductDTO = this.setUpProductDTO();
        ProductInfo productInfo = this.setUpProductInfo();
        when(this.productService.retrieveProduct(any(), any(), any())).thenReturn(productInfo);
        ResponseEntity<ProductDTO> response = this.controller.createProduct(newProductDTO);
        assertEquals(new ResponseEntity<>(HttpStatus.CONFLICT), response);
    }

    @Test
    void retrieveProductTest_OK() {
        BigDecimal productId = BigDecimal.valueOf(35455);
        BigDecimal brandId = BigDecimal.valueOf(1);
        String date = "2020-06-14T00:00:00";
        ProductInfo productInfo = this.setUpProductInfo();
        ProductInfoDTO productInfoDTO = this.setUpProductInfoDTO();
        when(this.productService.retrieveProduct(any(), any(), any())).thenReturn(productInfo);
        when(this.mapper.toProductInfoDTO(any())).thenReturn(productInfoDTO);
        ResponseEntity<ProductInfoDTO> response = this.controller.getProduct(productId, brandId, date);
        assertEquals(ResponseEntity.ok(productInfoDTO), response);
    }

    @Test
    void retrieveProductTest_NOT_FOUND() {
        BigDecimal productId = BigDecimal.valueOf(35455);
        BigDecimal brandId = BigDecimal.valueOf(1);
        String date = "2020-06-14T00:00:00";
        when(this.productService.retrieveProduct(any(), any(), any())).thenReturn(null);
        ResponseEntity<ProductInfoDTO> response = this.controller.getProduct(productId, brandId, date);
        assertEquals(ResponseEntity.notFound().build(), response);
    }

    @Test
    void updateProductTest_OK() {
        BigDecimal productId = BigDecimal.valueOf(35455);
        BigDecimal brandId = BigDecimal.valueOf(1);
        String date = "2020-06-14T00:00:00";
        ProductDTO productDTO = this.setUpProductDTO();
        ProductInfo productInfo = this.setUpProductInfo();
        when(this.productService.retrieveProduct(any(), any(), any())).thenReturn(productInfo);
        ResponseEntity<ProductDTO> response = this.controller.updateProduct(productId, brandId, date, productDTO);
        assertEquals(ResponseEntity.ok(productDTO), response);
    }

    @Test
    void updateProductTest_CREATED() {
        BigDecimal productId = BigDecimal.valueOf(35455);
        BigDecimal brandId = BigDecimal.valueOf(1);
        String date = "2020-06-14T00:00:00";
        ProductDTO productDTO = this.setUpProductDTO();
        when(this.productService.retrieveProduct(any(), any(), any())).thenReturn(null);
        ResponseEntity<ProductDTO> response = this.controller.updateProduct(productId, brandId, date, productDTO);
        assertEquals(new ResponseEntity<>(productDTO, HttpStatusCode.valueOf(201)), response);
    }


    @Test
    void deleteProductTest_NO_CONTENT() {
        BigDecimal productId = BigDecimal.valueOf(35455);
        BigDecimal brandId = BigDecimal.valueOf(1);
        String date = "2020-06-14T00:00:00";
        ProductInfo productInfo = this.setUpProductInfo();
        when(this.productService.retrieveProduct(any(), any(), any())).thenReturn(productInfo);
        ResponseEntity<ProductDTO> response = this.controller.deleteProduct(productId, brandId, date);
        assertEquals(ResponseEntity.noContent().build(), response);
    }

    @Test
    void deleteProductTest_NOT_FOUND() {
        BigDecimal productId = BigDecimal.valueOf(35455);
        BigDecimal brandId = BigDecimal.valueOf(1);
        String date = "2020-06-14T00:00:00";
        when(this.productService.retrieveProduct(any(), any(), any())).thenReturn(null);
        ResponseEntity<ProductDTO> response = this.controller.deleteProduct(productId, brandId, date);
        assertEquals(ResponseEntity.notFound().build(), response);
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
        return new Product(brandId, productId, priceList, priority, price, currency, startDate, endDate);
    }

    private ProductInfo setUpProductInfo() {
        BigDecimal productId = BigDecimal.valueOf(35455);
        BigDecimal brandId = BigDecimal.valueOf(1);
        int priceList = 1;
        BigDecimal price = BigDecimal.valueOf(15.50);
        String currency = "EUR";
        LocalDateTime startDate = LocalDateTime.parse("2020-06-14T00:00:00");
        LocalDateTime endDate = LocalDateTime.parse("2020-12-31T23:59:59");
        return new ProductInfo(brandId, productId, priceList, startDate, endDate, price, currency);
    }

    private ProductInfoDTO setUpProductInfoDTO() {
        ProductInfoDTO productInfoDto = new ProductInfoDTO();
        productInfoDto.setBrandId(BigDecimal.valueOf(1));
        productInfoDto.setProductId(BigDecimal.valueOf(35455));
        productInfoDto.setPriceList(1);
        productInfoDto.setPrice(BigDecimal.valueOf(15.50));
        productInfoDto.setCurrency("EUR");
        productInfoDto.setStartDate("2020-06-14T00:00:00");
        productInfoDto.setEndDate("2020-12-31T23:59:59");
        return productInfoDto;
    }


    private ProductDTO setUpProductDTO() {
        ProductDTO product = new ProductDTO();
        product.setBrandId(BigDecimal.valueOf(1));
        product.setProductId(BigDecimal.valueOf(35455));
        product.setPriceList(1);
        product.setPriority(0);
        product.setPrice(BigDecimal.valueOf(15.50));
        product.setCurrency("EUR");
        product.setStartDate("2020-06-14T00:00:00");
        product.setEndDate("2020-12-31T23:59:59");
        return product;
    }
}
