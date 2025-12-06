package ar.dev.maxisandoval.foodapieditjwt;

import ar.dev.maxisandoval.foodapieditjwt.entity.*;
import ar.dev.maxisandoval.foodapieditjwt.service.FoodService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.IntStream;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@AutoConfigureTestDatabase
@Transactional
@Slf4j
class FoodServiceTest {

    private final FoodService foodService;
    private final Faker faker = new Faker(Locale.forLanguageTag("es-AR"));

    private Food buildFakeFoodWithIngredients() {
        String dish = faker.food().dish();
        int calories = faker.number().numberBetween(100,800);

        log.info("dish -> "+dish);

        List<Ingredient> ingredients = new ArrayList<>();
        int ingredientCount = faker.number().numberBetween(2, 5);

        Food food = Food.builder()
                .name(dish)
                .calories(calories)
                .ingredients(ingredients)
                .build();

        ingredients.addAll(
                java.util.stream.IntStream.range(0, ingredientCount)
                        .mapToObj(i -> Ingredient.builder()
                                .name(faker.food().ingredient())
                                .food(food)
                                .build())
                        .toList()
        );

        return food;
    }

    @BeforeEach
    void setUp() {
        foodService.deleteAll();
        IntStream.range(0, 3).forEach(i -> foodService.save(buildFakeFoodWithIngredients()));
    }

    @Test
    void testGetAll() {
        List<Food> allFood = foodService.getAll();
        assertEquals(3, allFood.size());

        allFood.forEach(food -> {
            assertNotNull(food.getName());
            assertTrue(food.getCalories() > 0);
            assertFalse(food.getIngredients().isEmpty());
        });
    }

    @Test
    void testSaveAndGetById(){
        Food newFood = buildFakeFoodWithIngredients();
        Food savedFood = foodService.save(newFood);

        Food fetched = foodService.getById(savedFood.getId());

        assertEquals(savedFood.getId(), fetched.getId());
        assertEquals(savedFood.getName(), fetched.getName());
        assertEquals(savedFood.getCalories(), fetched.getCalories());
        assertEquals(savedFood.getIngredients().size(), fetched.getIngredients().size());
    }

    @Test
    void testUpdate() {
        Food originalFood = foodService.getAll().get(0);
        originalFood.setName("nameUpdated");
        originalFood.setCalories(123);

        Food updated = foodService.update(originalFood.getId(), originalFood);

        assertEquals("nameUpdated", updated.getName());
        assertEquals(123, updated.getCalories());
    }

    @Test
    void testDelete() {
        List<Food> foodList = foodService.getAll();
        Food food = foodList.get(0);
        int foodCount = foodList.size();

        foodService.deleteById(food.getId());

        assertEquals(foodCount-1, foodService.getAll().size());
    }

    @Test
    void testGetByIdNotFound() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> foodService.getById(9999L));
        assertTrue(exception.getMessage().contains("Food not found with id"));
    }
}