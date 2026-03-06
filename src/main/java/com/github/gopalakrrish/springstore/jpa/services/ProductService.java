package com.github.gopalakrrish.springstore.jpa.services;

import com.github.gopalakrrish.springstore.jpa.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@AllArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public void getProducts() {
        var products = productRepository.findProducts(BigDecimal.valueOf(5), BigDecimal.valueOf(10));
        System.out.println(products);
    }
}
