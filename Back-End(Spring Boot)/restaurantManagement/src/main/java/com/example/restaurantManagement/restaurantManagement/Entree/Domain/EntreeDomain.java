package com.example.restaurantManagement.restaurantManagement.Entree.Domain;

import com.example.restaurantManagement.restaurantManagement.Recipe.Domain.RecipeDomain;
import com.example.restaurantManagement.restaurantManagement.Restaurant.Domain.RestaurantDomain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Cascade;

import java.util.Set;

@Entity
public class EntreeDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    Double price;


    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference(value = "entreeEntry")
    private RestaurantDomain restaurantDomain;


    @OneToMany(fetch = FetchType.EAGER)
    @JsonManagedReference(value = "recipeEntreeKey")
    private Set<RecipeDomain> recipeDomains;


    public EntreeDomain(Integer id, String name, Double price, RestaurantDomain restaurantDomain, Set<RecipeDomain> recipeDomains) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.restaurantDomain = restaurantDomain;
        this.recipeDomains = recipeDomains;
    }

    public EntreeDomain() {
    }


    public RestaurantDomain getRestaurantDomain() {
        return restaurantDomain;
    }

    public void setRestaurantDomain(RestaurantDomain restaurantDomain) {
        this.restaurantDomain = restaurantDomain;
    }

    public Set<RecipeDomain> getRecipeDomains() {
        return recipeDomains;
    }

    public void setRecipeDomains(Set<RecipeDomain> recipeDomains) {
        this.recipeDomains = recipeDomains;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
