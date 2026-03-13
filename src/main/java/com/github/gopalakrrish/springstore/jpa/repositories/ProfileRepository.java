package com.github.gopalakrrish.springstore.jpa.repositories;

import com.github.gopalakrrish.springstore.jpa.dtos.UserSummary;
import com.github.gopalakrrish.springstore.jpa.entities.Profile;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
    @Query("select p.id as id, p.user.email as email from Profile p where p.loyaltyPoints > :loyaltyPoints")
    @EntityGraph(attributePaths = "user")
    List<UserSummary> findLoyalProfiles(@Param("loyaltyPoints") int loyaltyPoints);
}
