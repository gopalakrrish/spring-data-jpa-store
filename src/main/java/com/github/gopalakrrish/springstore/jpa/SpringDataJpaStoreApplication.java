package com.github.gopalakrrish.springstore.jpa;

import com.github.gopalakrrish.springstore.jpa.entities.User;
import com.github.gopalakrrish.springstore.jpa.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDataJpaStoreApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataJpaStoreApplication.class, args);
		var userRepository = context.getBean(UserRepository.class);

		var user = User.builder()
				.name("John")
				.email("john@gmail.com")
				.password("1234")
				.build();

		userRepository.save(user);

		userRepository.findAll().forEach(u -> System.out.println(u.getEmail()));

	}

}
