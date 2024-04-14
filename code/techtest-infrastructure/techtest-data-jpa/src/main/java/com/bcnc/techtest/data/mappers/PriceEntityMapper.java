package com.bcnc.techtest.data.mappers;

import com.bcnc.techtest.data.entities.PriceEntity;
import com.bcnc.techtest.domain.models.Price;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PriceEntityMapper {

    Price toPrice(PriceEntity priceEntity);

    List<Price> toPriceList(List<PriceEntity> priceEntityList);
}
