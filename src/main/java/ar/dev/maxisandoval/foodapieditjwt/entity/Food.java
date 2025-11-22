package ar.dev.maxisandoval.foodapieditjwt.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Food {

    private Long id;

    private String name;

    private Integer calories;
}