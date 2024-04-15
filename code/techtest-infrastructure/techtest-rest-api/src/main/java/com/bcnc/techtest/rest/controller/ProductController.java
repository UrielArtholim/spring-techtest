package com.bcnc.techtest.rest.controller;

import com.bcnc.techtest.api.ProductsApi;
import com.bcnc.techtest.domain.models.Product;
import com.bcnc.techtest.model.ProductDTO;
import com.bcnc.techtest.rest.mappers.ProductDTOMapper;
import com.bcnc.techtest.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

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
        Product retrievedProduct = this.retrieveService(productDTO);
        if(retrievedProduct != null)
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        this.productService.createProduct(this.mapper.toProduct(productDTO));
        return ResponseEntity.ok(productDTO);
    }

    @Override
    public ResponseEntity<ProductDTO> deleteProduct(Integer productId, Integer brandId, String dateId) {
        LocalDateTime date = LocalDateTime.parse(dateId);
        Product retrievedProduct = this.productService.retrieveProduct(brandId, productId, date);
        if(retrievedProduct == null)
            return ResponseEntity.notFound().build();
        this.productService.deleteProduct(brandId, productId, date);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<ProductDTO> getProduct(Integer productId, Integer brandId, String dateId) {
        LocalDateTime date = LocalDateTime.parse(dateId);
        Product retrievedProduct = this.productService.retrieveProduct(brandId, productId, date);
        if(retrievedProduct == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(this.mapper.toProductDTO(retrievedProduct));
    }

    @Override
    public ResponseEntity<ProductDTO> updateProduct(Integer productId, Integer brandId, String dateId, ProductDTO productDTO) {
        LocalDateTime date = LocalDateTime.parse(dateId);
        Product retrievedProduct = this.productService.retrieveProduct(brandId, productId, date);
        if(retrievedProduct == null)
        {
            this.productService.createProduct(this.mapper.toProduct(productDTO));
            return new ResponseEntity<>(productDTO, HttpStatusCode.valueOf(201));
        }
        this.productService.updateProduct(brandId, productId, date, this.mapper.toProduct(productDTO));
        return ResponseEntity.ok(productDTO);    }


    private Product retrieveService(ProductDTO productDTO)
    {
        return this.productService.retrieveProduct(productDTO.getBrandId(), productDTO.getProductId(),
          LocalDateTime.parse(productDTO.getStartDate()));
    }
}
