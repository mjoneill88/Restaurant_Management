package com.example.restaurantManagement.restaurantManagement.Inventory.Domain;

import com.example.restaurantManagement.restaurantManagement.Recipe.Domain.RecipeDomain;
import com.example.restaurantManagement.restaurantManagement.Restaurant.Domain.RestaurantDomain;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class InventoryDomain{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Double quantity;
    String quantityType;
    Integer threshold;
    String itemName;


    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference(value = "inventoryEntry")
    private RestaurantDomain restaurantDomain;


    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonManagedReference(value = "recipeKey")
    private Set<RecipeDomain> recipeDomains;

    public InventoryDomain(Integer id, Double quantity, String quantityType, Integer threshold, String itemName, RestaurantDomain restaurantDomain, Set<RecipeDomain> recipeDomains) {
        this.id = id;
        this.quantity = quantity;
        this.quantityType = quantityType;
        this.threshold = threshold;
        this.itemName = itemName;
        this.restaurantDomain = restaurantDomain;
        this.recipeDomains = recipeDomains;
    }

    public InventoryDomain() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getQuantityType() {
        return quantityType;
    }

    public void setQuantityType(String quantityType) {
        this.quantityType = quantityType;
    }

    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
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

    @Override
    public String toString() {
        return "InventoryDomain{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", quantityType='" + quantityType + '\'' +
                ", threshold=" + threshold +
                ", itemName='" + itemName + '\'' +
                ", restaurantDomain=" + restaurantDomain +
                ", recipeDomains=" + recipeDomains +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryDomain that = (InventoryDomain) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(quantityType, that.quantityType) &&
                Objects.equals(threshold, that.threshold) &&
                Objects.equals(itemName, that.itemName) &&
                Objects.equals(restaurantDomain, that.restaurantDomain) &&
                Objects.equals(recipeDomains, that.recipeDomains);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity, quantityType, threshold, itemName, restaurantDomain, recipeDomains);
    }
}