package com.bcnc.techtest.rest.mappers;

import com.bcnc.techtest.domain.models.Product;
import com.bcnc.techtest.domain.models.ProductInfo;
import com.bcnc.techtest.model.ProductDTO;
import com.bcnc.techtest.model.ProductInfoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductDTOMapper {

    ProductDTO toProductDTO(Product product);

    Product toProduct(ProductDTO productDTO);

    ProductInfoDTO toProductInfoDTO(ProductInfo productInfo);

    ProductInfo toProductInfo(ProductInfoDTO productInfoDTO);
}
