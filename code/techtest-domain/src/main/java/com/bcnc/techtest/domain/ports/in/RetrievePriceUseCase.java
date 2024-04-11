package com.bcnc.techtest.domain.ports.in;

import com.bcnc.techtest.domain.models.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface RetrievePriceUseCase {
    Price retrievePrice(int brandId, int priceId, LocalDateTime date);
    List<Price> retrieveAllPrices();
}
