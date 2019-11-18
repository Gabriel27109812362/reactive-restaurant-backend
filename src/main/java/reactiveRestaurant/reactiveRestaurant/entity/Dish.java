package reactiveRestaurant.reactiveRestaurant.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;
import java.util.UUID;



/**
 * Danie
 */
@Entity
public class Dish {

    @Id
    private UUID id;

    /**
     * Składniki dania
     */
    @ManyToMany
    private List<Ingredient> ingredients;

    /**
     * Cena dania
     */
    private double price;


    private Dish(List<Ingredient> ingredients, double price) {
        this.id = UUID.randomUUID();
        this.ingredients = ingredients;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public double getPrice() {
        return price;
    }
}
