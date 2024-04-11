package com.bcnc.techtest.domain.ports.in;

import com.bcnc.techtest.domain.models.Price;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface UpdatePriceUseCase {
    void updatePrice(int brandId, int priceId, int priceList, int priority,
                      BigDecimal price, String currency,
                      LocalDateTime startDate, LocalDateTime endDate);
}
