package com.github.gopalakrrish.springstore.jpa.repositories;

import com.github.gopalakrrish.springstore.jpa.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
