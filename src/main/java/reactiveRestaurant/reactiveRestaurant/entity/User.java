package reactiveRestaurant.reactiveRestaurant.entity;

import org.graalvm.compiler.core.common.type.ArithmeticOpTable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    private Credit_card credit_card;
    /**
     * adres
     */
    private Address address;


    public User(String name, String surname, String phoneNumber,
                String email, Credit_card credit_card, Address address) {

        this.id = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.credit_card = credit_card;
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

    public Credit_card getCredit_card() {
        return credit_card;
    }

    public void setCredit_card(Credit_card credit_card) {
        this.credit_card = credit_card;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }




}
