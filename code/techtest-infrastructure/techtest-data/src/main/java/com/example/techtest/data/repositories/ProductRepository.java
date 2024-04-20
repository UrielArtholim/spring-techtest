package com.example.techtest.data.repositories;

import com.example.techtest.data.entities.ProductEntity;
import com.example.techtest.data.entities.ProductKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, ProductKey> {

    @Query(value = "Select top 1 * " +
      "from PRICES " +
      "where BRAND_ID = :brandId " +
      "and PRODUCT_ID = :productId " +
      "and START_DATE <= :date " +
      "and END_DATE >= :date " +
      "order by PRIORITY desc", nativeQuery = true)
    ProductEntity findProduct(@Param("brandId") BigDecimal brandId, @Param("productId") BigDecimal productId, @Param("date") LocalDateTime date);

    @Modifying
    @Query(value = "Delete " +
      "from PRICES " +
      "where BRAND_ID = :brandId " +
      "and PRODUCT_ID = :productId " +
      "and START_DATE <= :date " +
      "and END_DATE >= :date ", nativeQuery = true)
    void deleteProduct(@Param("brandId") BigDecimal brandId, @Param("productId") BigDecimal productId, @Param("date") LocalDateTime date);

}
