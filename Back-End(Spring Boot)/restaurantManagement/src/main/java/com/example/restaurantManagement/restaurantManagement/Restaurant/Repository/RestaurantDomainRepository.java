package com.example.restaurantManagement.restaurantManagement.Restaurant.Repository;


import com.example.restaurantManagement.restaurantManagement.NotificationDTO.Domain.NotificationDto;
import com.example.restaurantManagement.restaurantManagement.Restaurant.Domain.RestaurantDomain;
import com.example.restaurantManagement.restaurantManagement.User.Domain.UserDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Repository
public interface RestaurantDomainRepository  extends JpaRepository<RestaurantDomain,Integer>{
    @Query(value ="SELECT * from rManagement.restaurant_domain where user_domain_id=:user_domain_id", nativeQuery = true)
    List<RestaurantDomain> getRestaurant(@RequestParam Integer user_domain_id);

    @Query(value = "SELECT ind.id,ind.item_name,ind.quantity,rd.name FROM rManagement.inventory_domain AS ind, rManagement.restaurant_domain AS rd  where ind.quantity<=ind.threshold and ind.restaurant_domain_id = rd.id and rd.user_domain_id=:id",nativeQuery = true)
    ArrayList<NotificationDto.notificationrepofunction> getNotification(@Param("id") Integer id);

}