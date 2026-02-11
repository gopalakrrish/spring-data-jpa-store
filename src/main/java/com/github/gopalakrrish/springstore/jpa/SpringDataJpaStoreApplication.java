package com.github.gopalakrrish.springstore.jpa;

import com.github.gopalakrrish.springstore.jpa.entities.Address;
import com.github.gopalakrrish.springstore.jpa.entities.Profile;
import com.github.gopalakrrish.springstore.jpa.entities.Tag;
import com.github.gopalakrrish.springstore.jpa.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJpaStoreApplication {

	public static void main(String[] args) {
//		SpringApplication.run(SpringDataJpaStoreApplication.class, args);

		var user = User.builder()
				.name("John")
				.email("john@gmail.com")
				.password("1234")
				.build();


		var profile = Profile.builder()
				.bio("xyz")
				.build();

		user.setProfile(profile);
		profile.setUser(user);

		System.out.println(user);

	}

}
