package com.bcnc.techtest.data.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;


@Setter
@Getter
@Entity
@Table(name = "PRICES")
@IdClass(ProductKey.class)
@Builder
public class ProductEntity {
    @Id
    @Column(name = "BRAND_ID")
    private BigDecimal brandId;
    @Id
    @Column(name = "PRODUCT_ID")
    private BigDecimal productId;
    @Column(name = "PRODUCT_LIST")
    private int priceList;
    @Column(name = "PRIORITY")
    private int priority;
    @Column(name = "PRICE")
    private BigDecimal price;
    @Column(name = "CURRENCY")
    private String currency;
    @Column(name = "START_DATE")
    private LocalDateTime startDate;
    @Column(name = "END_DATE")
    private LocalDateTime endDate;

    public ProductEntity() {
    }

    public ProductEntity(BigDecimal brandId, BigDecimal productId, int priceList, int priority, BigDecimal price, String currency,
                         LocalDateTime startDate, LocalDateTime endDate) {
        this.brandId = brandId;
        this.productId = productId;
        this.priceList = priceList;
        this.priority = priority;
        this.price = price;
        this.currency = currency;
        this.startDate = startDate;
        this.endDate = endDate;
    }

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