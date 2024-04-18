package com.example.techtest.domain.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class ProductInfo {
    @JsonProperty("brandId")
    private BigDecimal brandId;
    @JsonProperty("productId")
    private BigDecimal productId;
    @JsonProperty("priceList")
    private int priceList;
    @JsonProperty("price")
    private BigDecimal price;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("startDate")
    private LocalDateTime startDate;
    @JsonProperty("endDate")
    private LocalDateTime endDate;
}
