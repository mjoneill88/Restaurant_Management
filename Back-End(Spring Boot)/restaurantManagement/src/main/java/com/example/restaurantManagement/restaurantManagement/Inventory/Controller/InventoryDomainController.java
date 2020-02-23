package com.example.restaurantManagement.restaurantManagement.Inventory.Controller;

import com.example.restaurantManagement.restaurantManagement.Inventory.Domain.InventoryDomain;
import com.example.restaurantManagement.restaurantManagement.Inventory.Domain.InventoryDomain;
import com.example.restaurantManagement.restaurantManagement.Inventory.Repository.InventoryDomainRepository;
import jdk.jfr.internal.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = {"Origin", "X-Requested-With", "Content-Type", "Accept", "Authorization"},
        methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
public class InventoryDomainController{
    @Autowired
    private InventoryDomainRepository inventoryDomainRepository;

//    @CrossOrigin(allowedHeaders = {"Origin", "X-Requested-With", "Content-Type", "Accept", "Authorization"},
//            methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})


    @PostMapping(value = "/postInventory")
    public void createInventory(@RequestBody InventoryDomain inventoryDomain){
        inventoryDomainRepository.save(inventoryDomain);
    }

    @GetMapping(value = "/createInventory")
    public ArrayList<InventoryDomain> getAllInventories(){
        ArrayList<InventoryDomain> inventoryDomains = new ArrayList<>();
        for(InventoryDomain inventoryDomain : inventoryDomainRepository.findAll()){
            inventoryDomains.add(inventoryDomain);
        }
        return inventoryDomains;
    }

    @PutMapping(value ="/putInventory")
    public void updateInventory(@RequestBody InventoryDomain inventoryDomain){
        inventoryDomainRepository.save(inventoryDomain);
    }

    @DeleteMapping(value = "/deleteInventory")
    public void deleteInventory(@RequestParam Integer inventory_id){
        inventoryDomainRepository.deleteById(inventory_id);
    }

    @GetMapping(value ="/findInventory")
    public List<InventoryDomain> getRestaurantInventory(@RequestParam Integer restaurant_id){

        return inventoryDomainRepository.getInventory(restaurant_id);

    }
    @GetMapping(value ="/findSingleInventory")
    public InventoryDomain getInventory(@RequestParam Integer inventory_id){

        return inventoryDomainRepository.getSingleInventory(inventory_id);

    }
}