package reactiveRestaurant.reactiveRestaurant.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;
/**
 *  karta kredytowa
 */
@Entity
public class Credit_card {
    @Id
    private UUID id;
    /**
     * numer konta
     */
    private String number;


    /**
     * stan konta
     */
    private double balance;

    /**
     * nazwa banku
     */
    private String bank;




    public Credit_card(String number, double balance, String bank) {
        this.id = UUID.randomUUID();
        this.balance = balance;
        this.bank = bank;

    }

    public UUID getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }
}


