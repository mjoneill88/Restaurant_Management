package com.example.restaurantManagement.restaurantManagement.RecipeTest;

import com.example.restaurantManagement.restaurantManagement.Inventory.Domain.InventoryDomain;
import com.example.restaurantManagement.restaurantManagement.Recipe.Domain.RecipeDomain;
import com.example.restaurantManagement.restaurantManagement.Entree.Domain.EntreeDomain;

import org.junit.jupiter.api.*;
import static org.junit.Assert.*;
import com.example.restaurantManagement.restaurantManagement.Restaurant.Domain.RestaurantDomain;
import com.example.restaurantManagement.restaurantManagement.User.Domain.UserDomain;
import com.example.restaurantManagement.restaurantManagement.UserTest.UserDomainTest;
import org.junit.Assert;
import org.junit.Before;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;


//import org.junit.Test;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

import org.junit.runner.JUnitCore;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
//import org.junit.runner.RunWith;

//import org.springframework.boot.test.context.SpringBootTest;

//import mockit.Verifications;
//import mockit.integration.junit4.JMockit;

//Set<RestaurantDomain> testRestaurantDomain = new HashSet<>();
//testUserDomain = new UserDomain(1, "jdawg@gmail.com", "password", "jDawg", "John", "Dawson", testRestaurantDomain);

@SpringBootTest
public class RecipeDomainTest {

    private RecipeDomain testRecipeDomain;

    @Test
    public void testRecipeDomainConstructorWithParams() throws Exception{

        //Set<EntreeDomain> testEntreeDomain = new HashSet<>();
        //testEntreeDomain = (Set<EntreeDomain>) new EntreeDomain();

        //Set<InventoryDomain> testInventoryDomain = new HashSet<>();
        //testInventoryDomain = (Set<InventoryDomain>) new InventoryDomain();

        EntreeDomain testEntreeDomain = new EntreeDomain();
        InventoryDomain testInventoryDomain = new InventoryDomain();

        testRecipeDomain = new RecipeDomain(4, "Ham Sandwich", 20.1, testInventoryDomain, testEntreeDomain);

        assertTrue(testRecipeDomain.getId()==4);
        assertEquals("Ham Sandwich", testRecipeDomain.getName());
        assertTrue(testRecipeDomain.getQuantity()==20.1);
        assertEquals(testInventoryDomain, testRecipeDomain.getInventoryDomain());
        assertEquals(testEntreeDomain, testRecipeDomain.getEntreeDomain());
    }

    @Test
    public void testId(){
        testRecipeDomain = new RecipeDomain();
        assertTrue(testRecipeDomain.getId()==null);
        testRecipeDomain.setId(8);
        assertTrue(testRecipeDomain.getId()==8);
    }

    @Test
    public void testName(){
        testRecipeDomain = new RecipeDomain();
        assertEquals(null, testRecipeDomain.getName());
        testRecipeDomain.setName("Cynthia");
        assertEquals("Cynthia", testRecipeDomain.getName());
    }

    @Test
    public void testQuantity(){
        testRecipeDomain = new RecipeDomain();
        assertTrue(testRecipeDomain.getQuantity()==null);
        testRecipeDomain.setQuantity(88.8);
        assertTrue(testRecipeDomain.getQuantity()==88.8);
    }

}
