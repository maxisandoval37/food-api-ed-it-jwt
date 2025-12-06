package ar.dev.maxisandoval.foodapieditjwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FoodApiEdItJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodApiEdItJwtApplication.class, args);
    }

}