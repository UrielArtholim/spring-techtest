package com.bcnc.techtest.services;

import com.bcnc.techtest.domain.models.Price;
import com.bcnc.techtest.domain.ports.in.CreatePriceUseCase;
import com.bcnc.techtest.domain.ports.in.DeletePriceUseCase;
import com.bcnc.techtest.domain.ports.in.RetrievePriceUseCase;
import com.bcnc.techtest.domain.ports.in.UpdatePriceUseCase;
import com.bcnc.techtest.usecases.CreatePriceUseCaseImpl;
import com.bcnc.techtest.usecases.DeletePriceUseCaseImpl;
import com.bcnc.techtest.usecases.RetrievePriceUseCaseImpl;
import com.bcnc.techtest.usecases.UpdatePriceUseCaseImpl;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class PriceService implements CreatePriceUseCase, RetrievePriceUseCase, UpdatePriceUseCase, DeletePriceUseCase {

    private final CreatePriceUseCaseImpl createPriceUseCase;
    private final RetrievePriceUseCaseImpl retrievePriceUseCase;
    private final UpdatePriceUseCaseImpl updatePriceUseCase;
    private final DeletePriceUseCaseImpl deletePriceUseCase;

    public PriceService(final CreatePriceUseCaseImpl createPriceUseCase,
                        final RetrievePriceUseCaseImpl retrievePriceUseCase,
                        final UpdatePriceUseCaseImpl updatePriceUseCase,
                        final DeletePriceUseCaseImpl deletePriceUseCase) {
        this.createPriceUseCase = createPriceUseCase;
        this.retrievePriceUseCase = retrievePriceUseCase;
        this.updatePriceUseCase = updatePriceUseCase;
        this.deletePriceUseCase = deletePriceUseCase;
    }

    @Override
    public void createPrice(int brandId, int priceId, int priceList, int priority, BigDecimal price, String currency, LocalDateTime startDate, LocalDateTime endDate) {
        this.createPriceUseCase.createPrice(brandId, priceId, priceList, priority, price, currency, startDate, endDate);
    }

    @Override
    public Price retrievePrice(int brandId, int priceId, LocalDateTime date) {
        return this.retrievePriceUseCase.retrievePrice(brandId, priceId, date);
    }

    @Override
    public void updatePrice(int brandId, int priceId, int priceList, int priority, BigDecimal price, String currency, LocalDateTime startDate, LocalDateTime endDate) {
        this.updatePriceUseCase.updatePrice(brandId, priceId, priceList, priority, price, currency, startDate, endDate);
    }

    @Override
    public void deletePrice(int brandId, int product, LocalDateTime date) {
        this.deletePriceUseCase.deletePrice(brandId, product, date);
    }

}
