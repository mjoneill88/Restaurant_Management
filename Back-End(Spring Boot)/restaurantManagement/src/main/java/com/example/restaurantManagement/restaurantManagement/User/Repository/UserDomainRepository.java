package com.example.restaurantManagement.restaurantManagement.User.Repository;

import com.example.restaurantManagement.restaurantManagement.User.Domain.UserDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface UserDomainRepository extends JpaRepository<UserDomain,Integer> {
    @Query(value = "SELECT password FROM rManagement.user_domain where user_name=:userName",nativeQuery = true)
    String GetPassword(@RequestParam String userName);

    @Query(value = "SELECT id FROM rManagement.user_domain where user_name=:userName", nativeQuery = true)
    Integer GetId(@RequestParam String userName);
}
