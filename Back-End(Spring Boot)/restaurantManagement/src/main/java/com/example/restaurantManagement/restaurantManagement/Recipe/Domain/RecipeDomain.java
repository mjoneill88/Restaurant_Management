package com.example.restaurantManagement.restaurantManagement.Recipe.Domain;

import com.example.restaurantManagement.restaurantManagement.Entree.Domain.EntreeDomain;
import com.example.restaurantManagement.restaurantManagement.Inventory.Domain.InventoryDomain;
import com.example.restaurantManagement.restaurantManagement.Recipe.Domain.RecipeDomain;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.UniqueElements;
import sun.security.util.Password;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.Set;


@Entity
public class RecipeDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;
    Double quantity;


    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference(value = "recipeKey")
    private InventoryDomain inventoryDomain;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference(value = "recipeEntreeKey")
    private EntreeDomain entreeDomain;


    public RecipeDomain(Integer id, String name, Double quantity, InventoryDomain inventoryDomain, EntreeDomain entreeDomain) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.inventoryDomain = inventoryDomain;
        this.entreeDomain = entreeDomain;
    }

    public RecipeDomain() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public InventoryDomain getInventoryDomain() {
        return inventoryDomain;
    }

    public void setInventoryDomain(InventoryDomain inventoryDomain) {
        this.inventoryDomain = inventoryDomain;
    }

    public EntreeDomain getEntreeDomain() {
        return entreeDomain;
    }

    public void setEntreeDomain(EntreeDomain entreeDomain) {
        this.entreeDomain = entreeDomain;
    }

    public interface recipieDomain{
        Integer getId();
        String getName();
        Double getQuantity();
        InventoryDomain getInventoryDomain();
    }
}