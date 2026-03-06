package com.github.gopalakrrish.springstore.jpa.repositories;

import com.github.gopalakrrish.springstore.jpa.dtos.ProductSummaryDTO;
import com.github.gopalakrrish.springstore.jpa.entities.Category;
import com.github.gopalakrrish.springstore.jpa.entities.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query(value = "select * from products p where p.price between :min and :max order  by p.price desc", nativeQuery = true)
    List<Product> findProducts(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

    @Modifying
    @Query("update Product p set p.price = :newPrice where p.category.id = :categoryId")
    void updatePriceByCategory(BigDecimal newPrice, Byte categoryId);

    List<ProductSummaryDTO> findByCategory(Category category);
}
