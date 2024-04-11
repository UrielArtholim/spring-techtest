package com.bcnc.techtest.domain.ports.in;

import com.bcnc.techtest.domain.models.Price;

import java.time.LocalDateTime;

public interface RetrievePriceUseCase {
    Price retrievePrice(int brandId, int priceId, LocalDateTime date);
}
