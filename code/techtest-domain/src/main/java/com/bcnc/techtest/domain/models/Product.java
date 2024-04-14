package com.bcnc.techtest.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Product {
    private long brandId;
    private long productId;
    private int productList;
    private int priority;
    private BigDecimal price;
    private String currency;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}