package com.Spring.User.Service.UserService.controller;


import com.Spring.User.Service.UserService.entities.User;
import com.Spring.User.Service.UserService.services.UserServices;
//import org.apache.coyote.Response;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.annotation.CreatedDate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServices userServices;

    private Logger logger= LoggerFactory.getLogger(UserController.class);

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User us = userServices.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(us);
    }

    int retryCount=1;
    @GetMapping("/{uid}")
    @CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
    @Retry(name = "ratingHotelService",fallbackMethod = "ratingHotelFallback")
    @RateLimiter(name = "userRateLimiter",fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getUserById(@PathVariable String uid) {
        logger.info("Get single user handler: UserController");
        logger.info("Retry count : {}",retryCount);
        retryCount++;
        User u = userServices.getUser(uid);
        return ResponseEntity.ok(u);
    }

    //creating fall back method for circuitBreker

    public ResponseEntity<User> ratingHotelFallback(String uid,Exception ex){

        logger.info("Fallback is executed becouse service is down : ",ex.getMessage());

        User user=User.builder().email("dummy@gmail.com").name("Dummy")
                .about("This user is created dummy because some service is down")
                .uid("1234")
                .build();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<User>> findAllUser() {
        List<User> allUser = userServices.getAllUser();
        return ResponseEntity.ok(allUser);
    }
}
