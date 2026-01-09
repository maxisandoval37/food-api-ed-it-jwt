package ar.dev.maxisandoval.foodapieditjwt.controller;

import ar.dev.maxisandoval.foodapieditjwt.entity.Food;
import ar.dev.maxisandoval.foodapieditjwt.service.FoodService;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@AllArgsConstructor
@RequestMapping("/foods")
public class FoodController {

    private final FoodService foodService;
    private final HttpServletRequest request;

    @GetMapping("/all")
    public List<Food> getAll() {
        return foodService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Food getById(@PathVariable Long id) {
        return foodService.getById(id);
    }

    @PostMapping("/create")
    public Food create(@RequestBody Food food) {
        return foodService.save(food);
    }

    @PutMapping("/update/{id}")
    public Food update(@PathVariable Long id, @RequestBody Food food) {
        return foodService.update(id, food);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        foodService.deleteById(id);
    }

    //endpoint que se llama a otro endpoint de la misma app
    @GetMapping("/count")
    public ResponseEntity<Map<String, Object>> countFoods() {
        RestTemplate restTemplate = new RestTemplate();
        String url = ServletUriComponentsBuilder.fromCurrentContextPath().path("/foods/all").toUriString();

        // Reutilizar baerer token de la request original
        HttpHeaders headers = new HttpHeaders();
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (authHeader != null) {
            headers.set(HttpHeaders.AUTHORIZATION, authHeader);
        }

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<Food[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, Food[].class);

        Food[] foods = Objects.requireNonNullElseGet(response.getBody(), () -> new Food[0]);

        return ResponseEntity.ok(Map.of("cantidadComidas", foods.length));
    }
}