package com.github.gopalakrrish.springstore.jpa.repositories;

import com.github.gopalakrrish.springstore.jpa.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
