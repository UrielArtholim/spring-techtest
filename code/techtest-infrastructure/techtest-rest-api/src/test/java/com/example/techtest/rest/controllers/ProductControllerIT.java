package com.example.techtest.rest.controllers;

import com.example.techtest.domain.constants.CurrencyConstants;
import com.example.techtest.domain.models.ProductInfo;
import com.example.techtest.openapi.model.ProductInfoDTO;
import com.example.techtest.rest.controller.ProductController;
import com.example.techtest.rest.mappers.ProductDTOMapper;
import com.example.techtest.rest.mappers.ProductDTOMapperImpl;
import com.example.techtest.services.ProductService;
import com.example.techtest.usecases.CreateProductUseCaseImpl;
import com.example.techtest.usecases.DeleteProductUseCaseImpl;
import com.example.techtest.usecases.RetrieveProductUseCaseImpl;
import com.example.techtest.usecases.UpdateProductUseCaseImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = ProductController.class)
class ProductControllerIT {

    private final String baseEndpoint = "http://localhost:8080/techtest/api/products/";

    private TestRestTemplate restTemplate;

    @Autowired
    private ProductDTOMapperImpl mapper;

    @Autowired
    private ProductService productService;
    private ProductController productController;

    @BeforeEach
    void setUp() {

        this.productController = new ProductController(this.productService, this.mapper);
        this.restTemplate = new TestRestTemplate();
    }

    @Test
    void checkTest() {
        assertTrue(true);
    }

    @Test
    void RetrieveProduct_case1() throws Exception {
        ResponseEntity<ProductInfoDTO> expectedResponse = this.setUpExpectedResponse_case1();
        ProductInfoDTO expectedContent = expectedResponse.getBody();
        String date = "2020-06-14T10:00:00";
        if (expectedContent == null) {
            throw new NullPointerException("Case 1 expected content is null");
        }
        String endpoint = baseEndpoint + expectedContent.getProductId()
          + "/brand/" + expectedContent.getBrandId()
          + "/date/" + date;
        ResponseEntity<ProductInfoDTO> response = restTemplate.getForEntity(endpoint, ProductInfoDTO.class);
        assertEquals(expectedResponse, response);
    }

    @Test
    void RetrieveProduct_case2() throws Exception {
        ResponseEntity<ProductInfoDTO> expectedResponse = this.setUpExpectedResponse_case2();
        ProductInfoDTO expectedContent = expectedResponse.getBody();
        String date = "2020-06-14T16:00:00";
        if (expectedContent == null) {
            throw new NullPointerException("Case 1 expected content is null");
        }
        String endpoint = baseEndpoint + expectedContent.getProductId()
          + "/brand/" + expectedContent.getBrandId()
          + "/date/" + date;
        ResponseEntity<ProductInfoDTO> response = restTemplate.getForEntity(endpoint, ProductInfoDTO.class);
        assertEquals(expectedResponse, response);
    }

    @Test
    void RetrieveProduct_case3() throws Exception {
        ResponseEntity<ProductInfoDTO> expectedResponse = this.setUpExpectedResponse_case3();
        ProductInfoDTO expectedContent = expectedResponse.getBody();
        String date = "2020-06-14T21:00:00";
        if (expectedContent == null) {
            throw new NullPointerException("Case 1 expected content is null");
        }
        String endpoint = baseEndpoint + expectedContent.getProductId()
          + "/brand/" + expectedContent.getBrandId()
          + "/date/" + date;
        ResponseEntity<ProductInfoDTO> response = restTemplate.getForEntity(endpoint, ProductInfoDTO.class);
        assertEquals(expectedResponse, response);
    }

    @Test
    void RetrieveProduct_case4() throws Exception {
        ResponseEntity<ProductInfoDTO> expectedResponse = this.setUpExpectedResponse_case4();
        ProductInfoDTO expectedContent = expectedResponse.getBody();
        String date = "2020-06-15T10:00:00";
        if (expectedContent == null) {
            throw new NullPointerException("Case 1 expected content is null");
        }
        String endpoint = baseEndpoint + expectedContent.getProductId()
          + "/brand/" + expectedContent.getBrandId()
          + "/date/" + date;
        ResponseEntity<ProductInfoDTO> response = restTemplate.getForEntity(endpoint, ProductInfoDTO.class);
        assertEquals(expectedResponse, response);
    }

    @Test
    void RetrieveProduct_case5() throws Exception {
        ResponseEntity<ProductInfoDTO> expectedResponse = this.setUpExpectedResponse_case5();
        ProductInfoDTO expectedContent = expectedResponse.getBody();
        String date = "2020-06-15T21:00:00:00";
        if (expectedContent == null) {
            throw new NullPointerException("Case 1 expected content is null");
        }
        String endpoint = baseEndpoint + expectedContent.getProductId()
          + "/brand/" + expectedContent.getBrandId()
          + "/date/" + date;
        ResponseEntity<ProductInfoDTO> response = restTemplate.getForEntity(endpoint, ProductInfoDTO.class);
        assertEquals(expectedResponse, response);
    }

    private ProductInfo setUpProductInfo_case1() {
        return ProductInfo.builder()
          .brandId(BigDecimal.valueOf(1))
          .productId(BigDecimal.valueOf(35455))
          .priceList(1)
          .startDate(LocalDateTime.parse("2020-06-14T00:00:00"))
          .endDate(LocalDateTime.parse("2020-12-31T23:59:59"))
          .price(BigDecimal.valueOf(15.50))
          .currency("EUR")
          .build();
    }

    private ProductInfo setUpProductInfo_case2() {
        return ProductInfo.builder()
          .brandId(BigDecimal.valueOf(1))
          .productId(BigDecimal.valueOf(35455))
          .priceList(2)
          .startDate(LocalDateTime.parse("2020-06-14T15:00:00"))
          .endDate(LocalDateTime.parse("2020-06-14T18:30:00"))
          .price(BigDecimal.valueOf(15.50))
          .currency("EUR")
          .build();
    }

    private ProductInfo setUpProductInfo_case3() {
        return setUpProductInfo_case1();
    }

    private ProductInfo setUpProductInfo_case4() {
        return ProductInfo.builder()
          .brandId(BigDecimal.valueOf(1))
          .productId(BigDecimal.valueOf(35455))
          .priceList(3)
          .startDate(LocalDateTime.parse("2020-06-15T00:00:00"))
          .endDate(LocalDateTime.parse("2020-06-15T11:00:00"))
          .price(BigDecimal.valueOf(15.50))
          .currency("EUR")
          .build();
    }

    private ProductInfo setUpProductInfo_case5() {
        return ProductInfo.builder()
          .brandId(BigDecimal.valueOf(1))
          .productId(BigDecimal.valueOf(35455))
          .priceList(4)
          .startDate(LocalDateTime.parse("2020-06-15T16:00:00:00"))
          .endDate(LocalDateTime.parse("2020-12-31T23:59:59"))
          .price(BigDecimal.valueOf(15.50))
          .currency("EUR")
          .build();
    }

    private ResponseEntity<ProductInfoDTO> setUpExpectedResponse_case1() {
        ProductInfoDTO product = new ProductInfoDTO();
        product.setBrandId(BigDecimal.valueOf(1));
        product.setProductId(BigDecimal.valueOf(35455));
        product.setPriceList(1);
        product.setStartDate("2020-06-14T00:00:00");
        product.setEndDate("2020-12-31T23:59:59");
        product.setPrice(BigDecimal.valueOf(35.50));
        product.setCurrency(CurrencyConstants.EURO);
        return ResponseEntity.ok(product);
    }

    private ResponseEntity<ProductInfoDTO> setUpExpectedResponse_case2() {
        ProductInfoDTO product = new ProductInfoDTO();
        product.setBrandId(BigDecimal.valueOf(1));
        product.setProductId(BigDecimal.valueOf(35455));
        product.setPriceList(2);
        product.setStartDate("2020-06-14T15:00:00");
        product.setEndDate("2020-06-14T18:30:00");
        product.setPrice(BigDecimal.valueOf(25.45));
        product.setCurrency(CurrencyConstants.EURO);
        return ResponseEntity.ok(product);
    }

    private ResponseEntity<ProductInfoDTO> setUpExpectedResponse_case3() {
        return setUpExpectedResponse_case1();
    }

    private ResponseEntity<ProductInfoDTO> setUpExpectedResponse_case4() {
        ProductInfoDTO product = new ProductInfoDTO();
        product.setBrandId(BigDecimal.valueOf(1));
        product.setProductId(BigDecimal.valueOf(35455));
        product.setPriceList(3);
        product.setStartDate("2020-06-15T00:00:00");
        product.setEndDate("2020-06-15T11:00:00");
        product.setPrice(BigDecimal.valueOf(30.50));
        product.setCurrency(CurrencyConstants.EURO);
        return ResponseEntity.ok(product);
    }

    private ResponseEntity<ProductInfoDTO> setUpExpectedResponse_case5() {
        ProductInfoDTO product = new ProductInfoDTO();
        product.setBrandId(BigDecimal.valueOf(1));
        product.setProductId(BigDecimal.valueOf(35455));
        product.setPriceList(4);
        product.setStartDate("2020-06-15T16:00:00:00");
        product.setEndDate("2020-12-31T23:59:59");
        product.setPrice(BigDecimal.valueOf(38.95));
        product.setCurrency(CurrencyConstants.EURO);
        return ResponseEntity.ok(product);
    }


}
