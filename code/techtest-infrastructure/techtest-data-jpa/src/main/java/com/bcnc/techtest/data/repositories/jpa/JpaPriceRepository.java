package com.bcnc.techtest.data.repositories.jpa;

import com.bcnc.techtest.data.entities.PriceEntity;
import com.bcnc.techtest.domain.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface JpaPriceRepository extends JpaRepository<PriceEntity,Long> {

    void insertPrice(Price price);

    PriceEntity findPrice(int brandId, int priceId, LocalDateTime date);

    void updatePrice(Price price);

    void deletePrice(int brandId, int priceId, LocalDateTime date);
}
