package reactiveRestaurant.reactiveRestaurant.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Scanner;
import java.util.UUID;

/**
 * adres
 */
@Entity
public class Address {
    @Id
    private UUID id;

    private String street;

    /**
     * ulica
     */

    private String house_number;

    /**
     * numer domu
     */
    private String city;

    /**
     * nazwa miasta
     */
    private String postcode;


    /**
     * postcode
     */
    public Address(String street, String house_number, String city, String postcode) {
        this.id = UUID.randomUUID();
        this.street = street;
        this.house_number = house_number;
        this.city = city;
        this.postcode = postcode;

    }

    public UUID getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse_number() {
        return house_number;
    }

    public void setHouse_number(String house_number) {
        this.house_number = house_number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}