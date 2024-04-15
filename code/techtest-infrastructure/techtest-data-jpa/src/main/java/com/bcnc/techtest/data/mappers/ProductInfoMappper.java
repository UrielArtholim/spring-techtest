package com.bcnc.techtest.data.mappers;


import com.bcnc.techtest.data.entities.ProductEntity;
import com.bcnc.techtest.domain.models.ProductInfo;
import org.springframework.stereotype.Service;

@Service
public class ProductInfoMappper {

    public ProductInfoMappper() {
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
