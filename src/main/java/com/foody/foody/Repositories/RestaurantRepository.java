package com.foody.foody.Repositories;

import com.foody.foody.Models.RestaurantModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantModel,Long> {
    Optional<RestaurantModel> findByNameAndUserId(String name, Long id);
}
