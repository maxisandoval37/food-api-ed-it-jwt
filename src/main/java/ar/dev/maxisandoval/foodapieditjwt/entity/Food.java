package ar.dev.maxisandoval.foodapieditjwt.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer calories;

    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL, orphanRemoval = true)
    /*
    -cascade = CascadeType.ALL: Si guardas / eliminas un Food, afecta tambien a sus ingredients
    -orphanRemoval = true: Si eliminas un Ingredient lo borra tambien de la db, y no rompe la relación con Food.
     */
    private List<Ingredient> ingredients;
}