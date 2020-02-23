package com.example.restaurantManagement.restaurantManagement.UserTest;

//**
//import org.testng.annotations.Test;

        import org.junit.jupiter.api.*;

        import com.example.restaurantManagement.restaurantManagement.Restaurant.Domain.RestaurantDomain;
        import com.example.restaurantManagement.restaurantManagement.User.Domain.UserDomain;
        import org.junit.Assert;
//import org.junit.Before;
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






@SpringBootTest
public class UserDomainTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private UserDomain testUserDomain;



    @Test
    public void testUserDomainConstructorWithParams() throws Exception{
        //Not sure if this works
        //
        Set<RestaurantDomain> testRestaurantDomain = new HashSet<>();
        testUserDomain = new UserDomain(1, "jdawg@gmail.com", "password", "jDawg", "John", "Dawson", testRestaurantDomain);

        final Field field = testUserDomain.getClass().getDeclaredField("id");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(testUserDomain), 1);


        assertTrue( testUserDomain.getId()==1);
        assertEquals("jdawg@gmail.com", testUserDomain.getEmail());
        assertEquals("password", testUserDomain.getPassword());
        assertEquals("jDawg", testUserDomain.getUserName());
        assertEquals("John", testUserDomain.getFirstName());
        assertEquals("Dawson", testUserDomain.getLastName());
        assertEquals(testRestaurantDomain, testUserDomain.getRestaurantDomain());
    }

    @Test
    public void testId(){
        testUserDomain = new UserDomain();
        assertTrue(testUserDomain.getId()==null);
        testUserDomain.setId(13);
        assertTrue(testUserDomain.getId()==13);
    }

    @Test
    public void testEmail(){

        //No email initially
        testUserDomain = new UserDomain();
        assertEquals(null, testUserDomain.getEmail());
        testUserDomain.setEmail("random@gmail.com");
        assertEquals("random@gmail.com", testUserDomain.getEmail());
    }

    @Test
    public void testPassword(){
        testUserDomain = new UserDomain();
        assertEquals(null, testUserDomain.getPassword());
        testUserDomain.setPassword("Hello");
        assertEquals("Hello", testUserDomain.getPassword());
    }

    @Test
    public void testUserName(){
        testUserDomain = new UserDomain();
        assertEquals(null, testUserDomain.getUserName());
        //When username has a value
        testUserDomain.setUserName("mkin20");
        assertEquals("mkin20", testUserDomain.getUserName());
    }

    @Test
    public void testFirstName(){
        //no Firstname initially
        testUserDomain = new UserDomain();
        assertEquals(null, testUserDomain.getFirstName());
        //When firstName has a value
        testUserDomain.setFirstName("Matt");
        assertEquals("Matt", testUserDomain.getFirstName());
    }

    @Test
    public void testLastName(){
        //no Lastname initially
        testUserDomain = new UserDomain();
        assertEquals(null, testUserDomain.getLastName());
        //When lastName has a value
        testUserDomain.setLastName("Matt");
        assertEquals("Matt", testUserDomain.getLastName());
    }
}