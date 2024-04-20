package com.example.techtest.rest.controllers;

import com.example.techtest.application.services.ProductService;
import com.example.techtest.domain.models.Product;
import com.example.techtest.domain.models.ProductInfo;
import com.example.techtest.openapi.model.ProductDTO;
import com.example.techtest.openapi.model.ProductInfoDTO;
import com.example.techtest.rest.mappers.ProductDTOMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.example.techtest.domain.constants.CurrencyConstants.EURO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = ProductController.class)
class ProductControllerTest {

    @MockBean
    private ProductService service;

    @MockBean
    private ProductDTOMapper mapper;

    private ProductController controller;

    @BeforeEach
    void setUp() {
        this.controller = new ProductController(this.service, this.mapper);
    }

    @Test
    void createProduct_NotFound() {
        ProductDTO productDTO = this.setUpProductDTO();
        Product product = this.setUpProduct();

        when(this.service.retrieveProduct(any(), any(), any())).thenReturn(null);
        when(this.service.createProduct(any())).thenReturn(product);
        when(this.mapper.toProductDTO(any())).thenReturn(productDTO);

        ResponseEntity<ProductDTO> response = this.controller.createProduct(productDTO);
        verify(this.service).createProduct(any());
        assertNotNull(response);
        assertEquals(HttpStatusCode.valueOf(HttpStatus.CREATED.value()), response.getStatusCode());
        assertEquals(productDTO, response.getBody());
    }

    @Test
    void createProduct_Found() {
        ProductDTO product = this.setUpProductDTO();
        ProductInfo productInfo = this.setUpProductInfo();

        when(this.service.retrieveProduct(any(), any(), any())).thenReturn(productInfo);

        ResponseEntity<ProductDTO> response = this.controller.createProduct(product);
        assertNotNull(response);
        assertEquals(HttpStatusCode.valueOf(HttpStatus.CONFLICT.value()), response.getStatusCode());
    }


    @Test
    void getProduct() {
        BigDecimal brandId = BigDecimal.valueOf(1);
        BigDecimal productId = BigDecimal.valueOf(1);
        String date = "2020-06-14T00:00:00";
        ProductInfoDTO product = this.setUpProductInfoDTO();
        ProductInfo productInfo = this.setUpProductInfo();

        when(this.service.retrieveProduct(any(), any(), any())).thenReturn(productInfo);
        when(this.mapper.toProductInfoDTO(any())).thenReturn(product);

        ResponseEntity<ProductInfoDTO> response = this.controller.getProduct(productId, brandId, date);
        verify(this.service).retrieveProduct(any(), any(), any());
        assertNotNull(response);
        assertEquals(HttpStatusCode.valueOf(HttpStatus.OK.value()), response.getStatusCode());
        assertEquals(product, response.getBody());
    }


    @Test
    void updateProduct_createIfNotFound() {
        BigDecimal brandId = BigDecimal.valueOf(1);
        BigDecimal productId = BigDecimal.valueOf(1);
        String date = "2020-06-14T00:00:00";
        ProductDTO product = this.setUpProductDTO();

        when(this.service.retrieveProduct(any(), any(), any())).thenReturn(null);

        ResponseEntity<ProductDTO> response = this.controller.updateProduct(productId, brandId, date, product);
        verify(this.service).retrieveProduct(any(), any(), any());
        assertNotNull(response);
        assertEquals(HttpStatusCode.valueOf(HttpStatus.CREATED.value()), response.getStatusCode());
        assertEquals(product, response.getBody());
    }

    @Test
    void updateProduct_updateIfFound() {
        BigDecimal brandId = BigDecimal.valueOf(1);
        BigDecimal productId = BigDecimal.valueOf(1);
        String date = "2020-06-14T00:00:00";
        ProductDTO product = this.setUpUpdatedProductDTO();
        ProductInfo productInfo = this.setUpProductInfo();
        ProductInfoDTO productInfoDTO = this.setUpProductInfoDTO();

        when(this.service.retrieveProduct(any(), any(), any())).thenReturn(productInfo);
        when(this.mapper.toProductInfoDTO(any())).thenReturn(productInfoDTO);

        ResponseEntity<ProductDTO> response = this.controller.updateProduct(productId, brandId, date, product);
        verify(this.service).retrieveProduct(any(), any(), any());
        assertNotNull(response);
        assertEquals(HttpStatusCode.valueOf(HttpStatus.OK.value()), response.getStatusCode());
        assertEquals(product, response.getBody());
    }

    @Test
    void deleteProduct_Found() {
        when(this.service.retrieveProduct(any(), any(), any())).thenReturn(this.setUpProductInfo());
        BigDecimal brandId = BigDecimal.valueOf(1);
        BigDecimal productId = BigDecimal.valueOf(1);
        String date = "2020-06-14T00:00:00";
        this.controller.deleteProduct(brandId, productId, date);
        verify(this.service).deleteProduct(any(), any(), any());
    }

    @Test
    void deleteProduct_notFound() {
        when(this.service.retrieveProduct(any(), any(), any())).thenReturn(null);
        BigDecimal brandId = BigDecimal.valueOf(1);
        BigDecimal productId = BigDecimal.valueOf(1);
        String date = "2020-06-14T00:00:00";
        this.controller.deleteProduct(brandId, productId, date);
        verify(this.service, times(0)).deleteProduct(any(), any(), any());
    }

    private ProductDTO setUpProductDTO() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setBrandId(BigDecimal.valueOf(1));
        productDTO.setProductId(BigDecimal.valueOf(1));
        productDTO.setPriceList(1);
        productDTO.setPriority(0);
        productDTO.setStartDate("2020-06-14T00:00:00");
        productDTO.setEndDate("2020-12-31T23:59:59");
        productDTO.setPrice(BigDecimal.valueOf(10.00));
        productDTO.setCurrency(EURO);
        return productDTO;
    }

    private ProductDTO setUpUpdatedProductDTO() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setBrandId(BigDecimal.valueOf(1));
        productDTO.setProductId(BigDecimal.valueOf(1));
        productDTO.setPriceList(1);
        productDTO.setPriority(0);
        productDTO.setStartDate("2020-06-14T00:00:00");
        productDTO.setEndDate("2020-12-31T23:59:59");
        productDTO.setPrice(BigDecimal.valueOf(20.00));
        productDTO.setCurrency(EURO);
        return productDTO;
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

    private ProductInfoDTO setUpProductInfoDTO() {
        ProductInfoDTO productInfoDTO = new ProductInfoDTO();
        productInfoDTO.setBrandId(BigDecimal.valueOf(1));
        productInfoDTO.setProductId(BigDecimal.valueOf(1));
        productInfoDTO.setPriceList(1);
        productInfoDTO.setStartDate("2020-06-14T00:00:00");
        productInfoDTO.setEndDate("2020-12-31T23:59:59");
        productInfoDTO.setPrice(BigDecimal.valueOf(20.00));
        productInfoDTO.setCurrency(EURO);
        return productInfoDTO;
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

}
