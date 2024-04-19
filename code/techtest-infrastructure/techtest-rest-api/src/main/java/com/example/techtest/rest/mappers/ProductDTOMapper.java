package com.example.techtest.rest.mappers;

import com.example.techtest.domain.models.Product;
import com.example.techtest.domain.models.ProductInfo;
import com.example.techtest.openapi.model.ProductDTO;
import com.example.techtest.openapi.model.ProductInfoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductDTOMapper {

    ProductDTO toProductDTO(Product product);

    Product toProduct(ProductDTO productDTO);

    ProductInfoDTO toProductInfoDTO(ProductInfo productInfo);

    ProductInfo toProductInfo(ProductInfoDTO productInfoDTO);
}
