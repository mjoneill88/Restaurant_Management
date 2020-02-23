package com.example.restaurantManagement.restaurantManagement.Restaurant.Domain;

import com.example.restaurantManagement.restaurantManagement.Inventory.Domain.InventoryDomain;
import com.example.restaurantManagement.restaurantManagement.User.Domain.UserDomain;

import com.example.restaurantManagement.restaurantManagement.Entree.Domain.EntreeDomain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


import javax.persistence.*;

import java.util.Set;

@Entity
public class RestaurantDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    String street;

    String street2;

    String city;

    String state;

    String postal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference(value = "restaurantEntry")
    private UserDomain userDomain;


    @OneToMany(mappedBy = "restaurantDomain", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "entreeEntry")
    private Set<EntreeDomain> EntreeDomain;


    @OneToMany(mappedBy = "restaurantDomain", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "inventoryEntry")
    private  Set<InventoryDomain> InventoryDomain;

    public RestaurantDomain() {
    }


    public RestaurantDomain(Integer id, String name, String street, String street2, String city, String state, String postal) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.postal = postal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public UserDomain getUserDomain() {
        return userDomain;
    }

    public void setUserDomain(UserDomain userDomain) {
        this.userDomain = userDomain;
    }
}
