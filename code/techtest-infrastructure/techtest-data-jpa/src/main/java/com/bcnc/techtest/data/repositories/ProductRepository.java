package com.bcnc.techtest.data.repositories;

import com.bcnc.techtest.data.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query(value = "Select product " +
      "from ProductEntity product " +
      "where product.brandId = ?#{[0]} " +
      "and product.productId = ?#{[1]} " +
      "and product.startDate <= ?#{[2]} " +
      "and product.endDate >= ?#{[2]} " +
      "order by product.priority desc limit 1")
    ProductEntity findProduct(BigDecimal brandId, BigDecimal productId, LocalDateTime date);

    @Modifying
    @Query(value = "Delete " +
      "from ProductEntity product " +
      "where product.brandId = :brandId " +
      "and product.productId = :productId " +
      "and product.startDate <= :date " +
      "and product.endDate >= :date")
    void deleteProduct(@Param("brandId") BigDecimal brandId, @Param("productId") BigDecimal productId, @Param("date") LocalDateTime date);

}
