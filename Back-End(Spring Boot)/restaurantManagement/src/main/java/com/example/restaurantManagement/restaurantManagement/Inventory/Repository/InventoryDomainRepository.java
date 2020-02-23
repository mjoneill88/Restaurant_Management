package com.example.restaurantManagement.restaurantManagement.Inventory.Repository;

import com.example.restaurantManagement.restaurantManagement.Inventory.Domain.InventoryDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface InventoryDomainRepository extends JpaRepository<InventoryDomain,Integer> {

    @Query(value = "SELECT * from rManagement.inventory_domain where restaurant_domain_id=:restaurant_domain_id", nativeQuery = true)
    List<InventoryDomain> getInventory(@RequestParam Integer restaurant_domain_id);

    //    @Query(value ="SELECT * from rManagement.restaurant_domain where user_id=:user_id", nativeQuery = true)
    //    List<RestaurantDomain> getRestaurant(@RequestParam Integer user_id);

    @Query(value ="SELECT * from rManagement.inventory_domain where id=:inventory_id", nativeQuery = true)
    InventoryDomain getSingleInventory(@RequestParam Integer inventory_id);
}
