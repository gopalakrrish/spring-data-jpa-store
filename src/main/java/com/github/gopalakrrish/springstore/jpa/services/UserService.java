package com.github.gopalakrrish.springstore.jpa.services;

import com.github.gopalakrrish.springstore.jpa.entities.User;
import com.github.gopalakrrish.springstore.jpa.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final EntityManager entityManager;

    public void showEntityStates() {
        var user = User.builder()
                .name("John Doe")
                .email("john.doe@email.com")
                .password("abed")
                .build();

        System.out.println(entityManager.contains(user)
                ? "Persistent"
                : "Transient/Detached");


        userRepository.save(user);

        System.out.println(entityManager.contains(user)
                ? "Persistent"
                : "Transient/Detached");

    }
}
