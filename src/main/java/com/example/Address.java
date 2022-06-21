package com.example;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Address",schema = "TEST")
public class Address extends PanacheEntity {
//    @Id
//    private  Long AddressId;

    public Address() {
    }


    @Column
    private String AddressLine;
    @Column
    private String zipcode;
    @Column
    private String city;
    @Column
    private String country;

    public Address(String addressLine, String zipcode, String city, String country) {
        AddressLine = addressLine;
        this.zipcode = zipcode;
        this.city = city;
        this.country = country;

    }



    public String getAddressLine() {
        return AddressLine;
    }

    public void setAddressLine(String addressLine) {
        AddressLine = addressLine;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }



}
