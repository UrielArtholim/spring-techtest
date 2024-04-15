package com.bcnc.techtest.data.mappers;

import com.bcnc.techtest.data.entities.ProductEntity;
import com.bcnc.techtest.domain.models.Product;
import com.bcnc.techtest.domain.models.ProductInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = ProductInfoMappper.class)
class ProductInfoMapperTest {

    private ProductInfoMappper productInfoMappper;

    @BeforeEach
    void setUp()
    {
        this.productInfoMappper = new ProductInfoMappper();
    }

    @Test
    void toProductInfo_unitTest_OK()
    {
        ProductEntity productEntity = this.setUpProductEntity();
        ProductInfo expectedResponse = this.setUpProductInfo();
        ProductInfo result = this.productInfoMappper.toProductInfo(productEntity);
        assertEquals(expectedResponse, result);
    }

    private ProductInfo setUpProductInfo() {
        ProductInfo productInfo = ProductInfo.builder()
          .brandId(BigDecimal.valueOf(1))
          .productId(BigDecimal.valueOf(35455))
          .priceList(1)
          .startDate(LocalDateTime.parse("2020-06-14T00:00:00"))
          .endDate(LocalDateTime.parse("2020-12-31T23:59:59"))
          .price(BigDecimal.valueOf(15.50))
          .currency("EUR")
          .build();
        return productInfo;
    }

    private ProductEntity setUpProductEntity() {
        ProductEntity productEntity = ProductEntity.builder()
          .brandId(BigDecimal.valueOf(1))
          .productId(BigDecimal.valueOf(35455))
          .priceList(1)
          .priority(0)
          .startDate(LocalDateTime.parse("2020-06-14T00:00:00"))
          .endDate(LocalDateTime.parse("2020-12-31T23:59:59"))
          .price(BigDecimal.valueOf(15.50))
          .currency("EUR")
          .build();
        return productEntity;
    }

}
