package com.bcnc.techtest.usecases;

import com.bcnc.techtest.domain.ports.in.DeletePriceUseCase;
import com.bcnc.techtest.domain.ports.out.PriceRepositoryPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class DeletePriceUseCaseImpl implements DeletePriceUseCase {

    private final PriceRepositoryPort repository;

    public DeletePriceUseCaseImpl(final PriceRepositoryPort repository){
        this.repository = repository;
    }
    @Override
    public void deletePrice(int brandId, int product, LocalDateTime date) {
        this.repository.deletePrice(brandId, product, date);
        log.debug("|- Use Case: Delete Price -| ");
        log.debug("|- Status: COMPLETE -|");
    }
}
