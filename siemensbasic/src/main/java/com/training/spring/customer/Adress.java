package com.training.spring.customer;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adress {

    @Column(name = "CITY")
    private String city;
    private String streetName;
    private String town;
    private int postalcode;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public int getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(int postalcode) {
        this.postalcode = postalcode;
    }
}
