package com.bcnc.techtest.data.mappers;

import com.bcnc.techtest.data.entities.ProductEntity;
import com.bcnc.techtest.domain.models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductEntityMapper {
    ProductEntity toProductEntity(Product product);

    Product toProduct(ProductEntity productEntity);

    List<Product> toProductList(List<ProductEntity> productEntityList);
}
