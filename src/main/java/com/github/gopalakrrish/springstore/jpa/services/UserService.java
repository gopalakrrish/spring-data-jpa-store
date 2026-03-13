package com.github.gopalakrrish.springstore.jpa.services;

import com.github.gopalakrrish.springstore.jpa.entities.*;
import com.github.gopalakrrish.springstore.jpa.repositories.*;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final EntityManager entityManager;
    private final AddressRepository addressRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Transactional
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

    @Transactional
    public void showRelatedEntities() {
        var user = userRepository.findById(5L).orElseThrow();
        System.out.println(user.getEmail());

        var profile = profileRepository.findById(3L).orElseThrow();
        System.out.println(profile);

        // Now works because persistence context is active
        System.out.println(profile.getUser().getEmail());
    }

    public void persistRelated() {
        var user = User.builder()
                .name("Sachin")
                .email("sachin@gmail.com")
                .password("sachin1234")
                .build();

        var address = Address.builder()
                .street("street")
                .city("city")
                .state("state")
                .zip("zip")
                .build();

        user.addAddress(address);

        userRepository.save(user);
    }

    @Transactional
    public void deleteRelated() {
        var user = userRepository.findById(4L).orElseThrow();
        var address = user.getAddresses().getFirst();
        user.removeAddress(address);
        userRepository.save(user);
    }

    @Transactional
    public void manageProducts() {
        var user = userRepository.findById(4L).orElseThrow();
        var products = productRepository.findAll();
        products.forEach(user::addToWishlist);
        userRepository.save(user);
    }

    public void fetchUser() {
        var user = userRepository.findByEmail("john@gmail.com").orElseThrow();
        System.out.println(user);
    }

    @Transactional
    public void fetchUsers() {
        var users = userRepository.findAllWithAddresses();
        users.forEach((User u) -> {
            System.out.println(u);
            u.getAddresses().forEach(System.out::println);
        });
    }

    @Transactional
    public void printLoyalProfiles() {
        var profiles = profileRepository.findByLoyaltyPointsGreaterThan(2);
        profiles.forEach(p -> System.out.println(p.getId() + ": " + p.getUser().getEmail()));
    }
}
