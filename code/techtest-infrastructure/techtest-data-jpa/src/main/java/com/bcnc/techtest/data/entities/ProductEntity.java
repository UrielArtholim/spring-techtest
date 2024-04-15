package com.bcnc.techtest.data.entities;

import jakarta.persistence.*;
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
public class ProductEntity {
    @Id
    @Column(name = "BRAND_ID")
    private long brandId;
    @Id
    @Column(name = "PRODUCT_ID")
    private long productId;
    @Column(name = "PRODUCT_LIST")
    private int productList;
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

    public ProductEntity(Long brandId, Long productId, int productList, int priority, BigDecimal price, String currency,
                         LocalDateTime startDate, LocalDateTime endDate) {
        this.brandId = brandId;
        this.productId = productId;
        this.productList = productList;
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
        return productList == that.productList && priority == that.priority && Objects.equals(brandId, that.brandId) && Objects.equals(productId, that.productId) && Objects.equals(price, that.price) && Objects.equals(currency, that.currency) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brandId, productId, productList, priority, price, currency, startDate, endDate);
    }

}