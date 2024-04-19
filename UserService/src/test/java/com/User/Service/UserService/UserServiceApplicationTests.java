package com.User.Service.UserService;

import com.Spring.User.Service.UserService.UserServiceApplication;
import com.Spring.User.Service.UserService.entities.Rating;
import com.Spring.User.Service.UserService.externel.services.RatingService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
//@RunWith(SpringRunner.class)
//@SpringBootConfiguration
//@ContextConfiguration(classes = {UserServiceApplication.class, TestConfiguration.class})

class UserServiceApplicationTests {

    @Test
    void contextLoads() {
    }

//    @Autowired(required=true)
//    private RatingService ratingService;
//
//	@Test
//    void createRating() {
//        Rating rating = Rating.builder().rating("10").userId("").hotelId("").feedback("this is created using feign client").build();
//		Rating saveRating = ratingService.createRating(rating);
//		System.out.println("new rating created");
//
//	}

}
