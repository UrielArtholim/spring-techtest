package com.example.techtest.application.services;

import com.example.techtest.data.entities.ProductEntity;
import com.example.techtest.data.repositories.ProductRepository;
import com.example.techtest.domain.models.Product;
import com.example.techtest.domain.models.ProductInfo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static com.example.techtest.domain.constants.CurrencyConstants.EURO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class ProductServiceIT {

    private static Map<LocalDateTime, ProductEntity> expectedProducts;
    private DecimalFormat decimalFormat;

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProductRepository repository;

    @BeforeAll
    static void setUp() {
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setMinimumFractionDigits(2);
        decimalFormat.setMaximumFractionDigits(2);
        LocalDateTime use_case_1 = LocalDateTime.parse("2020-06-14T10:00:00");
        LocalDateTime use_case_2 = LocalDateTime.parse("2020-06-14T16:00:00");
        LocalDateTime use_case_3 = LocalDateTime.parse("2020-06-14T21:00:00");
        LocalDateTime use_case_4 = LocalDateTime.parse("2020-06-15T10:00:00");
        LocalDateTime use_case_5 = LocalDateTime.parse("2020-06-15T21:00:00");

        expectedProducts = new HashMap<>();
        expectedProducts.put(use_case_1, setUpExpectedProduct(1));
        expectedProducts.put(use_case_2, setUpExpectedProduct(2));
        expectedProducts.put(use_case_3, setUpExpectedProduct(3));
        expectedProducts.put(use_case_4, setUpExpectedProduct(4));
        expectedProducts.put(use_case_5, setUpExpectedProduct(5));
    }


    @ParameterizedTest
    @ValueSource(strings = {
      "2020-06-14T10:00:00",
      "2020-06-14T16:00:00",
      "2020-06-14T21:00:00",
      "2020-06-15T10:00:00",
      "2020-06-15T21:00:00"
    })
    void getProduct(String dateString) {
        BigDecimal brandId = BigDecimal.valueOf(1);
        BigDecimal productId = BigDecimal.valueOf(35455);
        LocalDateTime date = LocalDateTime.parse(dateString);
        ProductEntity expectedResponse = getExpectedProduct(date);
        ProductEntity response = this.repository.findProduct(brandId, productId, date);

        // Setting price field precision to 2 decimals, so the numeric values can match
        expectedResponse.setPrice(expectedResponse.getPrice().setScale(2, RoundingMode.UNNECESSARY));
        expectedResponse.setPrice(expectedResponse.getPrice().setScale(2, RoundingMode.UNNECESSARY));

        assertNotNull(response);
        assertEquals(getExpectedProduct(date), response);
    }

    private Product setUpProduct() {
        return Product.builder()
          .productId(BigDecimal.valueOf(1))
          .brandId(BigDecimal.valueOf(1))
          .priceList(1)
          .priority(0)
          .startDate(LocalDateTime.parse("2020-06-14T00:00:00"))
          .endDate(LocalDateTime.parse("2020-12-31T23:59:59"))
          .price(BigDecimal.valueOf(10.00))
          .currency("EUR")
          .build();
    }

    private Product setUpUpdatedProduct() {
        Product product = this.setUpProduct();
        product.setPrice(BigDecimal.valueOf(20.00));
        return product;
    }


    private ProductInfo setUpProductInfo() {
        return ProductInfo.builder()
          .productId(BigDecimal.valueOf(1))
          .brandId(BigDecimal.valueOf(1))
          .priceList(1)
          .startDate(LocalDateTime.parse("2020-06-14T00:00:00"))
          .endDate(LocalDateTime.parse("2020-12-31T23:59:59"))
          .price(BigDecimal.valueOf(10.00))
          .currency("EUR")
          .build();
    }

    private ProductInfo setUpUpdatedProductInfo() {
        ProductInfo productInfo = this.setUpProductInfo();
        productInfo.setPrice(BigDecimal.valueOf(20.00));
        return productInfo;
    }

    private static ProductEntity getExpectedProduct(LocalDateTime date) {
        return expectedProducts.get(date);
    }

    private static ProductEntity setUpExpectedProduct(int useCase) {
        return switch (useCase) {
            case 2 -> ProductEntity.builder()
              .brandId(BigDecimal.valueOf(1))
              .productId(BigDecimal.valueOf(35455))
              .priceList(2)
              .priority(1)
              .startDate(LocalDateTime.parse("2020-06-14T15:00:00"))
              .endDate(LocalDateTime.parse("2020-06-14T18:30:00"))
              .price(BigDecimal.valueOf(25.45))
              .currency(EURO).build();
            case 4 -> ProductEntity.builder()
              .brandId(BigDecimal.valueOf(1))
              .productId(BigDecimal.valueOf(35455))
              .priceList(3)
              .priority(1)
              .startDate(LocalDateTime.parse("2020-06-15T00:00:00"))
              .endDate(LocalDateTime.parse("2020-06-15T11:00:00"))
              .price(BigDecimal.valueOf(30.50))
              .currency(EURO).build();
            case 5 -> ProductEntity.builder()
              .brandId(BigDecimal.valueOf(1))
              .productId(BigDecimal.valueOf(35455))
              .priceList(4)
              .priority(1)
              .startDate(LocalDateTime.parse("2020-06-15T16:00:00"))
              .endDate(LocalDateTime.parse("2020-12-31T23:59:59"))
              .price(BigDecimal.valueOf(38.95))
              .currency(EURO).build();
            default -> ProductEntity.builder()
              .brandId(BigDecimal.valueOf(1))
              .productId(BigDecimal.valueOf(35455))
              .priceList(1)
              .priority(0)
              .startDate(LocalDateTime.parse("2020-06-14T00:00:00"))
              .endDate(LocalDateTime.parse("2020-12-31T23:59:59"))
              .price(BigDecimal.valueOf(35.50))
              .currency(EURO).build();
        };
    }
}
