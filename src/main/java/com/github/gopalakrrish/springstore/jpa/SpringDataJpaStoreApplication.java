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

		var user = User.builder()
						.name("user1")
						.build();

		user.addToWishlist(product);

		System.out.println(user);
	}

}
