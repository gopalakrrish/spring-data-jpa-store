package com.github.gopalakrrish.springstore.jpa.services;

import com.github.gopalakrrish.springstore.jpa.entities.Address;
import com.github.gopalakrrish.springstore.jpa.entities.User;
import com.github.gopalakrrish.springstore.jpa.repositories.AddressRepository;
import com.github.gopalakrrish.springstore.jpa.repositories.ProfileRepository;
import com.github.gopalakrrish.springstore.jpa.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final EntityManager entityManager;
    private final AddressRepository addressRepository;

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
}
