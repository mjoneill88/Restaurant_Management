package com.example.restaurantManagement.restaurantManagement.User.Domain;

import com.example.restaurantManagement.restaurantManagement.Restaurant.Domain.RestaurantDomain;
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
public class UserDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    //@Email
    String email;

    String password;
    //@Column(unique = true)
    String userName;

    String firstName;

    String lastName;

    @OneToMany(mappedBy = "userDomain",cascade = CascadeType.ALL)
    @JsonManagedReference(value = "restaurantEntry")
    private Set<RestaurantDomain> restaurantDomain;

    //private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    public UserDomain() {
    }

    public UserDomain(Integer id, String email, String password, String userName, String firstName, String lastName, Set<RestaurantDomain> restaurantDomain) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.restaurantDomain = restaurantDomain;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public Set<RestaurantDomain> getRestaurantDomain() {
        return restaurantDomain;
    }

    public void setRestaurantDomain(Set<RestaurantDomain> restaurantDomain) {
        this.restaurantDomain = restaurantDomain;
    }
}
