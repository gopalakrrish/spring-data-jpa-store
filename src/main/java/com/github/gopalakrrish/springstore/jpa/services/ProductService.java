package com.github.gopalakrrish.springstore.jpa.services;

import com.github.gopalakrrish.springstore.jpa.entities.Product;
import com.github.gopalakrrish.springstore.jpa.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
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

    @Transactional
    public  void updateProductPrices() {
        productRepository.updatePriceByCategory(BigDecimal.valueOf(10.5), (byte) 1);
    }

    @Transactional
    public void fetchProducts() {
        var products = productRepository.findProductsUsingSP(BigDecimal.valueOf(1),BigDecimal.valueOf(10));
        products.forEach(System.out::println);
    }

    public void fetchProductsByExample() {
        var product = new Product();
        product.setName("product");

        var matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        var example = Example.of(product, matcher);

        var products = productRepository.findAll(example);
        products.forEach(System.out::println);
    }

}
