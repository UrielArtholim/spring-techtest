package com.example.techtest.data.entities;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ProductKey implements Serializable {
    private BigDecimal productId;
    private BigDecimal brandId;
    private LocalDateTime startDate;
}
