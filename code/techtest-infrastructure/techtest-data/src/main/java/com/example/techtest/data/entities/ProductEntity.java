package com.example.techtest.data.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@Table(name = "PRICES")
@IdClass(ProductKey.class)
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class ProductEntity {
    @Id
    @Column(name = "BRAND_ID")
    private BigDecimal brandId;
    @Id
    @Column(name = "PRODUCT_ID")
    private BigDecimal productId;
    @Column(name = "PRICE_LIST")
    private int priceList;
    @Column(name = "PRIORITY")
    private int priority;
    @Column(name = "PRICE")
    private BigDecimal price;
    @Column(name = "CURRENCY")
    private String currency;
    @Id
    @Column(name = "START_DATE")
    private LocalDateTime startDate;
    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductEntity that)) return false;
        return priceList == that.priceList && priority == that.priority && Objects.equals(brandId, that.brandId) && Objects.equals(productId, that.productId) && Objects.equals(price, that.price) && Objects.equals(currency, that.currency) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandId, productId, priceList, priority, price, currency, startDate, endDate);
    }

}