package com.bcnc.techtest.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class PriceEntity {
    @Id
    private int brandId;
    @Id
    private int priceId;
    private int priceList;
    private int priority;
    private BigDecimal amount;
    private String currency;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
