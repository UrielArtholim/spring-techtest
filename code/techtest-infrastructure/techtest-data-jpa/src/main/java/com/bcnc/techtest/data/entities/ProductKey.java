package com.bcnc.techtest.data.entities;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ProductKey implements Serializable {
    private BigDecimal productId;
    private BigDecimal brandId;
}
