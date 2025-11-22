package ar.dev.maxisandoval.foodapieditjwt.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {

    private Long id;

    private String name;

    private Food food;
}