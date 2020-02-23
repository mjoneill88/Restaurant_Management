package com.example.restaurantManagement.restaurantManagement.Restaurant.Controller;


import com.example.restaurantManagement.restaurantManagement.NotificationDTO.Domain.NotificationDto;
import com.example.restaurantManagement.restaurantManagement.Restaurant.Domain.RestaurantDomain;
import com.example.restaurantManagement.restaurantManagement.Restaurant.Repository.RestaurantDomainRepository;
import com.example.restaurantManagement.restaurantManagement.User.Repository.UserDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin(allowedHeaders = {"Origin", "X-Requested-With", "Content-Type", "Accept", "Authorization"},
        methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
public class RestaurantDomainController {


    @Autowired
    private RestaurantDomainRepository restaurantDomainRepository;
    private UserDomainRepository userDomainRepository;

    @PostMapping(value = "/postRestaurant")
    public void createRestaurant(@RequestBody RestaurantDomain restaurantDomain){
        restaurantDomainRepository.save(restaurantDomain);

//        return ResponseEntity.ok();
    }

    @GetMapping(value = "/createRestaurant")
    public ArrayList<RestaurantDomain> getAllRestaurants(){
        ArrayList<RestaurantDomain> restaurantDomains = new ArrayList<>();
        for(RestaurantDomain restaurantDomain: restaurantDomainRepository.findAll()){
            restaurantDomains.add(restaurantDomain);
        }
        return restaurantDomains;
    }

    @GetMapping(value ="/findRestaurant")
    public List<RestaurantDomain> getUserRestaurants(@RequestParam Integer user_id){
//        List<RestaurantDomain> findRestaurant = new ArrayList<>();
//        findRestaurant.add(restaurantDomainRepository.getRestaurant(user_id));
//
//        return findRestaurant;

                return restaurantDomainRepository.getRestaurant(user_id);
//        for(RestaurantDomain restaurantDomain: restaurantDomainRepository.findById(user_id)){
//            restaurantDomains.add(restaurantDomain);
//        }
//        return restaurantDomains;

    }

    @PutMapping(value = "/putRestaurant")
    public void updateRestaurant(@RequestBody RestaurantDomain restaurantDomain){
        restaurantDomainRepository.save(restaurantDomain);
    }

    @DeleteMapping(value = "/deleteRestaurant")
    public void deleteRestaurant(@RequestParam Integer restaurant_id) {
        restaurantDomainRepository.deleteById(restaurant_id);
    }



    @GetMapping(value = "/getNotification")
    private ArrayList<NotificationDto.notificationrepofunction> getAllNotification(Integer id) {

        return restaurantDomainRepository.getNotification(id);

    }
}










