package com.bcnc.techtest.domain.ports.in;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface CreatePriceUseCase {
    void createPrice(int brandId, int priceId, int priceList, int priority, 
                       BigDecimal price, String currency, 
                       LocalDateTime startDate, LocalDateTime endDate);
}
