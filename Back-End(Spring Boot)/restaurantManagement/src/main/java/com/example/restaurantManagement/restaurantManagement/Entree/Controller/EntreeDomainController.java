package com.example.restaurantManagement.restaurantManagement.Entree.Controller;

import com.example.restaurantManagement.restaurantManagement.Entree.Domain.EntreeDomain;
import com.example.restaurantManagement.restaurantManagement.Entree.Repository.EntreeDomainRepository;
import com.example.restaurantManagement.restaurantManagement.Inventory.Domain.InventoryDomain;
import com.example.restaurantManagement.restaurantManagement.Inventory.Repository.InventoryDomainRepository;
import com.example.restaurantManagement.restaurantManagement.Recipe.Domain.RecipeDomain;
import com.example.restaurantManagement.restaurantManagement.Recipe.Repository.RecipeDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(allowedHeaders = {"Origin", "X-Requested-With", "Content-Type", "Accept", "Authorization"},
        methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE})
public class EntreeDomainController {

    @Autowired
    private EntreeDomainRepository entreeDomainRepository;

    @Autowired
    private InventoryDomainRepository inventoryDomainRepository;

    @Autowired
    private RecipeDomainRepository recipeDomainRepository;


    @PostMapping(value = "/postEntree")
    public void createEntree(@RequestBody EntreeDomain entreeDomain){

        entreeDomainRepository.save(entreeDomain);

//        return ResponseEntity.ok();
    }

    @GetMapping(value = "/getEntree")
    public ArrayList<EntreeDomain> getAllEntrees(){
        ArrayList<EntreeDomain> entreeDomains = new ArrayList<>();
        for (EntreeDomain entreeDomain: entreeDomainRepository.findAll()){
            entreeDomains.add(entreeDomain);
        }
        return entreeDomains;
    }

    @PutMapping(value = "/putEntree")
    public void updateEntree(@RequestBody EntreeDomain entreeDomain){
        entreeDomainRepository.save(entreeDomain);
    }

    @DeleteMapping(value = "/deleteEntree")
    public void deleteEntree(@RequestParam Integer entree_id){
        entreeDomainRepository.deleteById(entree_id);
    }


    @GetMapping(value ="/findEntree")
    public List<EntreeDomain> getUserRestaurants(@RequestParam Integer restaurant_id){

        return entreeDomainRepository.getEntree(restaurant_id);

    }
    @GetMapping(value ="/findSingleEntree")
    public EntreeDomain getInventory(@RequestParam Integer entree_id){

        return entreeDomainRepository.getSingleEntree(entree_id);

    }


    @GetMapping(value = "/placeOrder")
    public void placeOrder(@RequestParam Integer entreeId){
        ArrayList<RecipeDomain> recipeDomains = entreeDomainRepository.getReciepeDomain(entreeId);
        for (RecipeDomain recipeDomain:recipeDomains){
            Integer inventoryId = entreeDomainRepository.getInventoryIdByreciepeId(recipeDomain.getId());
            InventoryDomain inventoryDomain = inventoryDomainRepository.findById(inventoryId).orElse(null);
            if(inventoryDomain!=null){
                inventoryDomain.setQuantity((Double) (inventoryDomain.getQuantity()-recipeDomain.getQuantity()));
                inventoryDomainRepository.save(inventoryDomain);
            }

        }
//        return ResponseEntity.status(HttpStatus.OK);ResponseEntity.BodyBuilder
    }
}
