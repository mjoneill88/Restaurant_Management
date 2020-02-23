package com.example.restaurantManagement.restaurantManagement.RestaurantTest;

import com.example.restaurantManagement.restaurantManagement.Restaurant.Domain.RestaurantDomain;
import com.example.restaurantManagement.restaurantManagement.User.Domain.UserDomain;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;






@SpringBootTest
public class RestaurantDomainTest {

    private RestaurantDomain testRestaurantDomain;


    @Test
    public void testRestaurantDomainConstructorWithParams() throws Exception{


        Set<RestaurantDomain> testRestaurantDomain2 = new HashSet<>();
        UserDomain testUserDomain = new UserDomain(1, "jdawg@gmail.com", "password", "jDawg", "John", "Dawson", testRestaurantDomain2);

//        testRestaurantDomain = new RestaurantDomain(5, "Carrabbas", "124 74th St. Charlotte NC 27312", testUserDomain);

        assertTrue(testRestaurantDomain.getId()==5);
        assertEquals("Carrabbas", testRestaurantDomain.getName());
//        assertEquals("124 74th St. Charlotte NC 27312", testRestaurantDomain.getAddress());
    }

    @Test
    public void testId(){

        testRestaurantDomain = new RestaurantDomain();
        assertTrue(testRestaurantDomain.getId()==null);
        testRestaurantDomain.setId(6);
        assertTrue(testRestaurantDomain.getId()==6);
    }

    @Test
    public void testName(){
        testRestaurantDomain = new RestaurantDomain();
        assertEquals(null, testRestaurantDomain.getName());

        testRestaurantDomain.setName("McDonalds");
        assertEquals("McDonalds", testRestaurantDomain.getName());
    }

//    @Test
//    public void testAddress(){
//        testRestaurantDomain = new RestaurantDomain();
//        assertEquals(null, testRestaurantDomain.getAddress());
//        testRestaurantDomain.setAddress("124 74th St. Charlotte NC 27312");
//        assertEquals("124 74th St. Charlotte NC 27312", testRestaurantDomain.getAddress());
//    }
}
