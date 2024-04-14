package com.bcnc.techtest.domain.ports.in;

import com.bcnc.techtest.domain.models.Price;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface CreatePriceUseCase {
    void createPrice(Price price);
}
