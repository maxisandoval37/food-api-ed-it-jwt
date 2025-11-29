package ar.dev.maxisandoval.foodapieditjwt.repository;

import ar.dev.maxisandoval.foodapieditjwt.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
}