package com.example.techtest.data.mappers;

import com.example.techtest.data.entities.ProductEntity;
import com.example.techtest.domain.models.Product;
import com.example.techtest.domain.models.ProductInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductEntityMapper {

    ProductEntity toProductEntity(Product product);
    ProductInfo toProductInfo(ProductEntity productEntity);
    Product toProduct(ProductEntity productEntity);
}
