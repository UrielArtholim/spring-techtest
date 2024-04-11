package com.bcnc.techtest.usecases;

import com.bcnc.techtest.domain.ports.in.UpdatePriceUseCase;
import com.bcnc.techtest.domain.ports.out.PriceRepositoryPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Slf4j
@Component
public class UpdatePriceUseCaseImpl implements UpdatePriceUseCase {
    private final PriceRepositoryPort repository;

    public UpdatePriceUseCaseImpl(final PriceRepositoryPort repository){
        this.repository = repository;
    }
    @Override
    public void updatePrice(int brandId, int priceId, int priceList, int priority, BigDecimal price, String currency, LocalDateTime startDate, LocalDateTime endDate) {
        this.repository.updatePrice(brandId, priceId, priceList, priority, price, currency, startDate, endDate);
        log.debug("|- Use Case: Update Price -| ");
        log.debug("|- Status: COMPLETE -|");
    }
}
