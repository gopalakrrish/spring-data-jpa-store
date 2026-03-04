package com.github.gopalakrrish.springstore.jpa;

import com.github.gopalakrrish.springstore.jpa.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDataJpaStoreApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataJpaStoreApplication.class, args);
		var userService = context.getBean(UserService.class);
		userService.deleteRelated();

	}

}
