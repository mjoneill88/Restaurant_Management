package com.example.restaurantManagement.restaurantManagement.Recipe.Repository;

import com.example.restaurantManagement.restaurantManagement.Inventory.Domain.InventoryDomain;
import com.example.restaurantManagement.restaurantManagement.Recipe.Domain.RecipeDomain;
import com.example.restaurantManagement.restaurantManagement.User.Domain.UserDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface RecipeDomainRepository extends JpaRepository<RecipeDomain,Integer>{
    @Query(value = "SELECT * from rManagement.recipe_domain where entree_domain_id=:entree_domain_id", nativeQuery = true)
    List<RecipeDomain> getRecipe(@RequestParam Integer entree_domain_id);

    @Query(value = "SELECT * FROM rmanagement.inventory_domain where rmanagement.inventory_domain.restaurant_domain_id=:resId and inventory_domain.id NOT IN (SELECT rmanagement.recipe_domain.inventory_domain_id from rmanagement.recipe_domain where rmanagement.recipe_domain.entree_domain_id=:entreeId)",nativeQuery = true)
    List<InventoryDomain> getInventoryToAddRecipe(@RequestParam Integer resId, @RequestParam Integer entreeId);

}






