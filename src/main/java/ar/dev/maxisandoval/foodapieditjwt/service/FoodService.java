package ar.dev.maxisandoval.foodapieditjwt.service;

import ar.dev.maxisandoval.foodapieditjwt.entity.Food;
import ar.dev.maxisandoval.foodapieditjwt.repository.FoodRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;

    @Cacheable("foods")
    public List<Food> getAll() {
        return foodRepository.findAll();
    }

    @Cacheable(value = "food", key = "#id")
    public Food getById(Long id) {
        return foodRepository.findById(id).orElseThrow(() -> new RuntimeException("Food not found with id: "+id));
    }

    @CachePut(value = "food", key = "#result.id")
    public Food save(Food food) {
        return foodRepository.save(food);
    }

    @CachePut(value = "food", key = "#id")
    public Food update(Long id, Food updatedFood) {
        Food existingFood = getById(id);
        existingFood.setName(updatedFood.getName());
        existingFood.setCalories(updatedFood.getCalories());

        return foodRepository.save(existingFood);
    }

    @CacheEvict(value = "foods", allEntries = true)
    public void deleteById(Long id) {
        foodRepository.deleteById(id);
    }

    @CacheEvict(value = "foods", allEntries = true)
    public void deleteAll() {
        foodRepository.deleteAll();
    }
}