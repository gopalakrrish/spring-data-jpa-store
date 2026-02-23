package com.github.gopalakrrish.springstore.jpa.repositories;

import com.github.gopalakrrish.springstore.jpa.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
