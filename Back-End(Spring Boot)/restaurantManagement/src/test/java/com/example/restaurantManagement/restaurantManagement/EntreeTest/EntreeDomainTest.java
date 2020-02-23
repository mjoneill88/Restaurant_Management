package com.example.restaurantManagement.restaurantManagement.EntreeTest;

import com.example.restaurantManagement.restaurantManagement.Restaurant.Domain.RestaurantDomain;
import com.example.restaurantManagement.restaurantManagement.User.Domain.UserDomain;

import org.junit.jupiter.api.*;
import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.HashSet;
import java.util.Set;

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

import com.example.restaurantManagement.restaurantManagement.Entree.Domain.EntreeDomain;
import com.example.restaurantManagement.restaurantManagement.Restaurant.Domain.RestaurantDomain;
import com.example.restaurantManagement.restaurantManagement.Recipe.Domain.RecipeDomain;



@SpringBootTest
public class EntreeDomainTest {
    private EntreeDomain testEntreeDomain;

    @Test
    public void testEntreeDomainConstructorWithParams(){



        RestaurantDomain testRestaurantDomain = new RestaurantDomain();

        Set<RecipeDomain> testRecipeDomain = new HashSet<>();

        testEntreeDomain = new EntreeDomain(1, "Spaghetti", 10.5, testRestaurantDomain, testRecipeDomain);


        assertTrue(testEntreeDomain.getId()==1);
        assertEquals("Spaghetti", testEntreeDomain.getName());
        assertTrue(testEntreeDomain.getPrice()==10.5);

    }

    @Test
    public void testId(){
        //no id initially
        testEntreeDomain = new EntreeDomain();

        assertTrue(testEntreeDomain.getId()==null);

        //When id has value
        testEntreeDomain.setId(2);

        assertTrue(testEntreeDomain.getId()==2);
    }

    @Test
    public void testName(){
        //no name initially
        testEntreeDomain = new EntreeDomain();


        assertEquals(null, testEntreeDomain.getName());

        //When Name has a value
        testEntreeDomain.setName("Burrito");

        assertEquals("Burrito", testEntreeDomain.getName());

    }

    @Test
    public void testSetPrice(){
        //no price initially
        testEntreeDomain = new EntreeDomain();
        assertTrue(testEntreeDomain.getId()==null);

        //When Price has a value
        testEntreeDomain.setPrice(6.75);
        assertTrue(testEntreeDomain.getPrice()==6.75);

    }
}

