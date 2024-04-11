package com.bcnc.techtest.usecases;

import com.bcnc.techtest.domain.models.Price;
import com.bcnc.techtest.domain.ports.in.RetrievePriceUseCase;
import com.bcnc.techtest.domain.ports.out.PriceRepositoryPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class RetrievePriceUseCaseImpl implements RetrievePriceUseCase {
    private final PriceRepositoryPort repository;

    public RetrievePriceUseCaseImpl(final PriceRepositoryPort repository){
        this.repository = repository;
    }
    @Override
    public Price retrievePrice(int brandId, int priceId, LocalDateTime date) {
        Price price = this.repository.retrievePrice(brandId, priceId, date);
        log.debug("|- Use Case: Retrieve Price -| ");
        log.debug("|- Status: COMPLETE -|");
        return price;
    }
}
