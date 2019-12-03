package reactiveRestaurant.reactiveRestaurant.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;
/**
 * uzytkownik
 */
@Entity
public class User {
    @Id
    private UUID id;
    /**
     * imie użytkownika
     */
    private String name;
    /**
     * nazwisko użytkownika
     */
    private String surname;
    /**
     * numer telefonu użytkownika
     */
    private String phoneNumber;
    /**
     * adres email użytkownika
     */
    private String email;
    /**
     * numer karty
     */
    private CreditCard creditCard;
    /**
     * adres
     */
    private Address address;


    public User(String name, String surname, String phoneNumber,
                String email, CreditCard creditCard, Address address) {

        this.id = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.creditCard= creditCard;
        this.address = address;
    }

    public UUID getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
