package com.bcnc.techtest.rest.dtos;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ProductDTO {
    @Min(1)
    private long brandId;
    @Min(1)
    private long productId;
    @Min(1)
    private int productList;
    @Min(0)
    private int priority;
    @DecimalMin(value = "1")
    private BigDecimal price;
    @NotBlank
    private String currency;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDate;

}
