package com.bcnc.techtest.domain.ports.out;

import com.bcnc.techtest.domain.models.Price;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface PriceRepositoryPort {
    void createPrice(int brandId, int priceId, int priceList, int priority,
                     BigDecimal price, String currency,
                     LocalDateTime startDate, LocalDateTime endDate);
    Price retrievePrice(int brandId, int priceId, LocalDateTime date);
    void updatePrice(int brandId, int priceId, int priceList, int priority,
                     BigDecimal price, String currency,
                     LocalDateTime startDate, LocalDateTime endDate);
    void deletePrice(int brandId, int priceId, LocalDateTime date);
}
