package com.bcnc.techtest.usecases;

import com.bcnc.techtest.domain.models.Price;
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
    public void updatePrice(Price price) {
        this.repository.updatePrice(price);
        log.debug("|- Use Case: Update Price -| ");
        log.debug("|- Status: COMPLETE -|");
    }
}
