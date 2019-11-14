package reactiveRestaurant.reactiveRestaurant.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Zamówienie
 */
@Entity
public class Order {

    @Id
    private UUID id;

    /**
     * Status zamówienia
     */
    private String state;

    /**
     * Dania wchodzące w skład zamówienia
     */
    @OneToMany
    private List<Dish> dishes;

    /**
     * Całkowity koszt zamówienia
     */
    private double totalCost;

    /**
     * Data rozpoczęcia realizacji
     */
    private Date accept_date;

    /**
     * Data zakończenia realizacji
     */
    private Date finish_date;


    public Order(List<Dish> dishes, double totalCost, Date accept_date, Date finish_date) {
        this.id = UUID.randomUUID();
        this.state = "pending";
        this.dishes = dishes;
        this.totalCost = totalCost;
        this.accept_date = accept_date;
        this.finish_date = finish_date;
    }

    public UUID getId() {
        return id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public Date getAccept_date() {
        return accept_date;
    }

    public void setAccept_date(Date accept_date) {
        this.accept_date = accept_date;
    }

    public Date getFinish_date() {
        return finish_date;
    }

    public void setFinish_date(Date finish_date) {
        this.finish_date = finish_date;
    }
}
