package reactiveRestaurant.reactiveRestaurant.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

/**
 * Składnik dania
 */
@Entity
public class Ingredient {

    @Id
    private UUID id;

    /**
     * Nazwa składnika
     */
    private String name;


    public Ingredient(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }
}
