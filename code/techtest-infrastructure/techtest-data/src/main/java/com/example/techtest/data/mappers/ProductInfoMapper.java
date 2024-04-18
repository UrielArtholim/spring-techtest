package com.example.techtest.data.mappers;


import com.example.techtest.data.entities.ProductEntity;
import com.example.techtest.domain.models.ProductInfo;
import org.springframework.stereotype.Service;

@Service
public class ProductInfoMapper {

    public ProductInfoMapper() {
        //default constructor
    }

    public ProductInfo toProductInfo(ProductEntity productEntity) {
        return ProductInfo.builder()
          .brandId(productEntity.getBrandId())
          .productId(productEntity.getProductId())
          .priceList(productEntity.getPriceList())
          .startDate(productEntity.getStartDate())
          .endDate(productEntity.getEndDate())
          .price(productEntity.getPrice())
          .currency(productEntity.getCurrency())
          .build();
    }
}
