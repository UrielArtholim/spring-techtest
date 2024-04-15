package com.bcnc.techtest.data.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductKey implements Serializable {
    private long productId;
    private long brandId;
}
