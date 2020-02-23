package com.example.restaurantManagement.restaurantManagement.Recipe.Controller;


import com.example.restaurantManagement.restaurantManagement.Inventory.Domain.InventoryDomain;
import com.example.restaurantManagement.restaurantManagement.Recipe.Domain.RecipeDomain;
import com.example.restaurantManagement.restaurantManagement.Recipe.Repository.RecipeDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = {"Origin", "X-Requested-With", "Content-Type", "Accept", "Authorization"},
        methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})

public class RecipeDomainController {

    @Autowired
    private RecipeDomainRepository recipeDomainRepository;

    @PostMapping(value = "/postRecipe")
    public void createRecipe(@RequestBody RecipeDomain recipeDomain)
    {
        recipeDomainRepository.save(recipeDomain);

//        return ResponseEntity.ok();
    }

    @GetMapping(value = "/getRecipe")
    public ArrayList<RecipeDomain> getAllRecipes()
    {
        ArrayList<RecipeDomain> recipeDomains = new ArrayList<>();
        for(RecipeDomain recipeDomain: recipeDomainRepository.findAll()){
            recipeDomains.add(recipeDomain);
        }
        return recipeDomains;
    }


    @PutMapping(value ="/createRecipe")
    public void updateRecipe(@RequestBody RecipeDomain recipeDomain){
        recipeDomainRepository.save(recipeDomain);
    }

    @DeleteMapping(value = "/deleteRecipe")
    public void deleteReipe(@RequestParam Integer recipe_id){
        recipeDomainRepository.deleteById(recipe_id);
    }

    @GetMapping(value ="/findRecipe")
    public List<RecipeDomain> getRecipe(@RequestParam Integer entree_domain_id){

        return recipeDomainRepository.getRecipe(entree_domain_id);

    }


    @GetMapping(value = "/getRecipeeInventory")
    public List<InventoryDomain> getInventory(@RequestParam Integer resId, @RequestParam Integer entreeId){
        return recipeDomainRepository.getInventoryToAddRecipe(resId,entreeId);
    }
}