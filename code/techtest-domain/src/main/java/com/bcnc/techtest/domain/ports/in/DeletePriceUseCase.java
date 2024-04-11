package com.bcnc.techtest.domain.ports.in;

import java.time.LocalDateTime;

public interface DeletePriceUseCase {
    void deletePrice(int brandId, int product, LocalDateTime date);
}
