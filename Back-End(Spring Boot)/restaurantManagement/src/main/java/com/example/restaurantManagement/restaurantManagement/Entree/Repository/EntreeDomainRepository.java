package com.example.restaurantManagement.restaurantManagement.Entree.Repository;

import com.example.restaurantManagement.restaurantManagement.Entree.Domain.EntreeDomain;
import com.example.restaurantManagement.restaurantManagement.Recipe.Domain.RecipeDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface EntreeDomainRepository extends JpaRepository<EntreeDomain, Integer> {

    @Query(value="SELECT * from rManagement.entree_domain where restaurant_domain_id=:restaurant_domain_id", nativeQuery = true)
    List<EntreeDomain> getEntree(@RequestParam Integer restaurant_domain_id);

    @Query(value ="SELECT * from rManagement.entree_domain where id=:entree_id", nativeQuery = true)
    EntreeDomain getSingleEntree(@RequestParam Integer entree_id);

    @Query(value = " SELECT * from rManagement.recipe_domain where rManagement.recipe_domain.entree_domain_id = :id",nativeQuery = true)
    ArrayList<RecipeDomain> getReciepeDomain(@RequestParam Integer id);

    @Query(value = "SELECT inventory_domain_id FROM rmanagement.recipe_domain where id =:id",nativeQuery = true)
    Integer getInventoryIdByreciepeId(@RequestParam Integer id);

    //    @Query(value ="SELECT * from rManagement.restaurant_domain where user_id=:user_id", nativeQuery = true)
//    List<RestaurantDomain> getRestaurant(@RequestParam Integer user_id);

    /*    @Query(value = "SELECT password FROM rManagement.user_domain where user_name=:userName",nativeQuery = true)
    String GetPassword(@RequestParam String userName);
*/

}
