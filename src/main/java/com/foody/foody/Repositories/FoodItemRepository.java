package com.foody.foody.Repositories;

import com.foody.foody.Models.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem,Long>{

    List<FoodItem> findByRestaurantId(Long id);
}
