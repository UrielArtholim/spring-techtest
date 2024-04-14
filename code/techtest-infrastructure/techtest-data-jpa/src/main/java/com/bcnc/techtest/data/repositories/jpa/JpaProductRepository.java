package com.bcnc.techtest.data.repositories.jpa;

import com.bcnc.techtest.data.entities.ProductEntity;
import com.bcnc.techtest.data.entities.ProductId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface JpaProductRepository extends JpaRepository<ProductEntity, ProductId> {

    @Query(value = "Select product " +
      "from ProductEntity product " +
      "where product.brandId = ?#{[0]} " +
      "and product.productId = ?#{[1]} " +
      "and product.startDate <= ?#{[2]} " +
      "and product.endDate >= ?#{[2]} " +
      "order by product.priority desc limit 1")
    ProductEntity findProduct(long brandId, long productId, LocalDateTime date);

    @Modifying
    @Query(value = "Delete " +
      "from ProductEntity product " +
      "where product.brandId = :brandId " +
      "and product.productId = :productId " +
      "and product.startDate <= :date " +
      "and product.endDate >= :date")
    void deleteProduct(@Param("brandId") long brandId, @Param("productId") long productId, @Param("date") LocalDateTime date);
}
