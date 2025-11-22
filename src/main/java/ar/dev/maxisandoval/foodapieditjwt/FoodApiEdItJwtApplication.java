package ar.dev.maxisandoval.foodapieditjwt;

import ar.dev.maxisandoval.foodapieditjwt.entity.Food;
import ar.dev.maxisandoval.foodapieditjwt.entity.Ingredient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FoodApiEdItJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodApiEdItJwtApplication.class, args);

        Food food = new Food(1L, "Asado", 12);

        Ingredient ingredient = new Ingredient();

        ingredient.getFood();

    }

}
