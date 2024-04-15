package com.bcnc.techtest.data.mappers;

import com.bcnc.techtest.data.entities.ProductEntity;
import com.bcnc.techtest.domain.models.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductEntityMapper {
    ProductEntity toProductEntity(Product product);
    Product toProduct(ProductEntity productEntity);
}
