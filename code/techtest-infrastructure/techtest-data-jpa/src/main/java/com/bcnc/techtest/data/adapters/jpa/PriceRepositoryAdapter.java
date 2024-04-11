package com.bcnc.techtest.data.adapters.jpa;

import com.bcnc.techtest.data.entities.PriceEntity;
import com.bcnc.techtest.data.mappers.PriceEntityMapper;
import com.bcnc.techtest.data.repositories.jpa.JpaPriceRepository;
import com.bcnc.techtest.domain.models.Price;
import com.bcnc.techtest.domain.ports.out.PriceRepositoryPort;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class PriceRepositoryAdapter implements PriceRepositoryPort {

    private final JpaPriceRepository repository;
    private final PriceEntityMapper mapper;

    public PriceRepositoryAdapter(final JpaPriceRepository repository, final PriceEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void createPrice(Price price) {
        if(this.retrievePrice(price) == null)
            this.repository.insertPrice(price);
    }

    @Override
    public Price retrievePrice(int brandId, int priceId, LocalDateTime date) {
        PriceEntity priceEntity = this.repository.findPrice(brandId, priceId, date);
        return this.mapper.toPrice(priceEntity);
    }

    @Override
    public List<Price> retrieveAllPrices() {
        List<PriceEntity> priceEntityList = this.repository.findAll();
        return this.mapper.toPriceList(priceEntityList);
    }

    @Override
    public void updatePrice(Price price) {
        if(this.retrievePrice(price) != null)
            this.repository.updatePrice(price);
    }

    @Override
    public void deletePrice(int brandId, int priceId, LocalDateTime date) {
        if(this.retrievePrice(brandId, priceId, date) != null)
            this.repository.deletePrice(brandId,priceId, date);
    }

    private Price retrievePrice (Price price)
    {
        return this.retrievePrice(price.getBrandId(), price.getPriceId(), price.getStartDate());
    }

}
