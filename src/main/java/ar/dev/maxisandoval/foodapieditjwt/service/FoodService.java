package ar.dev.maxisandoval.foodapieditjwt.service;

import ar.dev.maxisandoval.foodapieditjwt.entity.Food;
import ar.dev.maxisandoval.foodapieditjwt.repository.FoodRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;

    public List<Food> getAll() {
        return foodRepository.findAll();
    }

    public Food getById(Long id) {
        return foodRepository.findById(id).orElseThrow(() -> new RuntimeException("Food not found with id: "+id));
    }

    public Food save(Food food) {
        return foodRepository.save(food);
    }

    public Food update(Long id, Food updatedFood) {
        Food existingFood = getById(id);
        existingFood.setName(updatedFood.getName());
        existingFood.setCalories(updatedFood.getCalories());

        return foodRepository.save(existingFood);
    }

    public void deleteById(Long id){
        foodRepository.deleteById(id);
    }

    public void deleteAll() {
        foodRepository.deleteAll();
    }
}