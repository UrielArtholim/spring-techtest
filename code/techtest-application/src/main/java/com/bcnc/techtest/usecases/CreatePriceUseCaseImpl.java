package com.bcnc.techtest.usecases;

import com.bcnc.techtest.domain.models.Price;
import com.bcnc.techtest.domain.ports.in.CreatePriceUseCase;
import com.bcnc.techtest.domain.ports.out.PriceRepositoryPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Slf4j
@Component
public class CreatePriceUseCaseImpl implements CreatePriceUseCase {

    private final PriceRepositoryPort repository;

    public CreatePriceUseCaseImpl(final PriceRepositoryPort repository){
        this.repository = repository;
    }
    @Override
    public void createPrice(Price price){
        this.repository.createPrice(price);
        log.debug("|- Use Case: Create Price -| ");
        log.debug("|- Status: COMPLETE -|");
    }
}
