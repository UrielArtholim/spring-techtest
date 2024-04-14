package com.bcnc.techtest.rest.mappers;

import com.bcnc.techtest.domain.models.Product;
import com.bcnc.techtest.rest.dtos.ProductDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RestDTOMapper {

    Product toProduct(ProductDTO productDTO);

    ProductDTO toProductDTO(Product product);

    List<ProductDTO> toProductDTOList(List<Product> productList);
}
