package com.example;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="customer",schema = "TEST")
public class User extends PanacheEntity {
@Column
    private String firstname;
    @Column
    private String lastname;
    @Column
    private String gender;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,
            orphanRemoval = true)

    @JoinColumn(name="AddressId")
 private List<Address> address;

    public User() {
    }

    public User(String firstname, String lastname, String gender, List<Address> address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", gender='" + gender + '\'' +
                ", address=" + address +
                '}';
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

