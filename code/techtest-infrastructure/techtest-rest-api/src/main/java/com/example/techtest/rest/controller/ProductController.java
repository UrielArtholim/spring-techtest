package com.example.techtest.rest.controller;

import com.example.techtest.api.ProductsApi;
import com.example.techtest.domain.models.ProductInfo;
import com.example.techtest.model.ProductDTO;
import com.example.techtest.model.ProductInfoDTO;
import com.example.techtest.rest.mappers.ProductDTOMapper;
import com.example.techtest.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RestController
public class ProductController implements ProductsApi {

    private final ProductService productService;
    private final ProductDTOMapper mapper;

    public ProductController(final ProductService productService, final ProductDTOMapper mapper) {
        this.productService = productService;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<ProductDTO> createProduct(ProductDTO productDTO) {
        ProductInfo retrievedProduct = this.retrieveService(productDTO);
        if (retrievedProduct != null)
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        this.productService.createProduct(this.mapper.toProduct(productDTO));
        return ResponseEntity.ok(productDTO);
    }

    @Override
    public ResponseEntity<ProductDTO> deleteProduct(BigDecimal productId, BigDecimal brandId, String dateId) {
        LocalDateTime date = LocalDateTime.parse(dateId);
        ProductInfo retrievedProduct = this.productService.retrieveProduct(brandId, productId, date);
        if (retrievedProduct == null)
            return ResponseEntity.notFound().build();
        this.productService.deleteProduct(brandId, productId, date);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<ProductInfoDTO> getProduct(BigDecimal productId, BigDecimal brandId, String dateId) {
        LocalDateTime date = LocalDateTime.parse(dateId);
        ProductInfo retrievedProduct = this.productService.retrieveProduct(brandId, productId, date);
        if (retrievedProduct == null)
            return ResponseEntity.notFound().build();
        ProductInfoDTO productInfoDTO = this.mapper.toProductInfoDTO(retrievedProduct);
        return ResponseEntity.ok(productInfoDTO);
    }

    @Override
    public ResponseEntity<ProductDTO> updateProduct(BigDecimal productId, BigDecimal brandId, String dateId, ProductDTO productDTO) {
        LocalDateTime date = LocalDateTime.parse(dateId);
        ProductInfo retrievedProduct = this.productService.retrieveProduct(brandId, productId, date);
        if (retrievedProduct == null) {
            this.productService.createProduct(this.mapper.toProduct(productDTO));
            return new ResponseEntity<>(productDTO, HttpStatusCode.valueOf(201));
        }
        this.productService.updateProduct(brandId, productId, date, this.mapper.toProduct(productDTO));
        return ResponseEntity.ok(productDTO);
    }


    private ProductInfo retrieveService(ProductDTO productDTO) {
        return this.productService.retrieveProduct(productDTO.getBrandId(), productDTO.getProductId(),
          LocalDateTime.parse(productDTO.getStartDate()));
    }
}
