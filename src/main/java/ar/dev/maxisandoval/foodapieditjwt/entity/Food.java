package ar.dev.maxisandoval.foodapieditjwt.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String name;

    @NotNull
    @Min(value = 0, message = "Las calorias no pueden ser negativas")
    private Integer calories;

    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL, orphanRemoval = true)
    /*
    -cascade = CascadeType.ALL: Si guardas / eliminas un Food, afecta tambien a sus ingredients
    -orphanRemoval = true: Si eliminas un Ingredient lo borra tambien de la db, y no rompe la relación con Food.
     */
    private List<Ingredient> ingredients;
}