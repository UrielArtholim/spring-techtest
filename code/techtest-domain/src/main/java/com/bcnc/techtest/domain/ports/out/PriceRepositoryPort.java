package com.bcnc.techtest.domain.ports.out;

import com.bcnc.techtest.domain.models.Price;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepositoryPort {
    void createPrice(Price price);
    Price retrievePrice(int brandId, int priceId, LocalDateTime date);
    List<Price> retrieveAllPrices();
    void updatePrice(Price price);
    void deletePrice(int brandId, int priceId, LocalDateTime date);
}
