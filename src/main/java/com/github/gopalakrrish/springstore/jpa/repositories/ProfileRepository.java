package com.github.gopalakrrish.springstore.jpa.repositories;

import com.github.gopalakrrish.springstore.jpa.entities.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}
