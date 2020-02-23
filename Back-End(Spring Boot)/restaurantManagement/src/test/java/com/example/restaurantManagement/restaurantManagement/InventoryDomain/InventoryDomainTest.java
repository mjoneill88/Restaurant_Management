package com.example.restaurantManagement.restaurantManagement.InventoryDomain;

import com.example.restaurantManagement.restaurantManagement.Recipe.Domain.RecipeDomain;
import com.example.restaurantManagement.restaurantManagement.Restaurant.Domain.RestaurantDomain;
import com.example.restaurantManagement.restaurantManagement.Inventory.Domain.InventoryDomain;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class InventoryDomainTest {
    InventoryDomain testInventoryDomain;

    @Test
    public void testInventoryDomainConstructorWithParameters(){

        RestaurantDomain testRestaurantDomain = new RestaurantDomain();
        Set<RecipeDomain> testRecipeDomain = new HashSet<>();
//        testInventoryDomain = new InventoryDomain(4, 7, 10, "Onion", testRestaurantDomain, testRecipeDomain);
    }

    @Test
    public void testId(){
        testInventoryDomain = new InventoryDomain();
        assertTrue(testInventoryDomain.getId()==null);
        testInventoryDomain.setId(9);
        assertTrue(testInventoryDomain.getId()==9);
    }

    @Test
    public void testQuantity(){
        testInventoryDomain = new InventoryDomain();
        assertTrue(testInventoryDomain.getQuantity()==null);
        testInventoryDomain.setQuantity(5.0);
        assertTrue(testInventoryDomain.getQuantity()==5);
    }

    @Test
    public void testThreshold(){
        testInventoryDomain = new InventoryDomain();
        assertTrue(testInventoryDomain.getThreshold()==null);
        testInventoryDomain.setThreshold(29);
        assertTrue(testInventoryDomain.getThreshold()==29);
    }

}
