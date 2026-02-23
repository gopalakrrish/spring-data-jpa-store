package com.github.gopalakrrish.springstore.jpa;

import com.github.gopalakrrish.springstore.jpa.entities.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class SpringDataJpaStoreApplication {

	public static void main(String[] args) {
//		SpringApplication.run(SpringDataJpaStoreApplication.class, args);

		var product = new Product();
		product.setId(1L);
		product.setName("product1");
		product.setDescription("this is product1");
		product.setPrice(BigDecimal.TEN);

		var category = new Category();
		category.setId((byte) 1);
		category.setName("category1");

//		category.addProduct(product);
		category.getProducts().add(product);
		product.setCategory(category);

		System.out.println(product);
		System.out.println(category);
	}

}
