package com.bcnc.techtest.rest.mappers;

import com.bcnc.techtest.domain.models.Product;
import com.bcnc.techtest.model.ProductDTO;
import org.mapstruct.Mapper;

@Mapper
public interface ProductDTOMapper {

    ProductDTO toProductDTO(Product product);

    Product toProduct(ProductDTO productDTO);
}
