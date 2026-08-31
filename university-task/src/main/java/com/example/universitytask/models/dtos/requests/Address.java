package com.example.universitytask.models.dtos.requests;

import lombok.Getter;

import java.util.Objects;

public class Address {
    @Getter
    private String street;

    private String city;
    private String state;
    private String zip;

    //empty constructor
    public Address() {
    }

    //all args constructor
    public Address(
            String street,
            String city,
            String state,
            String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

//    public String getStreet() {
//        return street;
//    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(street, address.street)
                && Objects.equals(city, address.city)
                && Objects.equals(state, address.state)
                && Objects.equals(zip, address.zip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, city, state, zip);
    }


    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}
