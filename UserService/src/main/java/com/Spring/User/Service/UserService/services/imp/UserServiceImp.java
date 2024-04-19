package com.Spring.User.Service.UserService.services.imp;

import com.Spring.User.Service.UserService.entities.Hotel;
import com.Spring.User.Service.UserService.entities.Rating;
import com.Spring.User.Service.UserService.entities.User;
import com.Spring.User.Service.UserService.externel.services.HotelService;
import com.Spring.User.Service.UserService.repositories.UserRepository;
import com.Spring.User.Service.UserService.exception.ResourseNotFoundException;
import com.Spring.User.Service.UserService.services.UserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    private Logger logger = LoggerFactory.getLogger(UserServiceImp.class);

    @Override
    public User saveUser(User user) {
        String ranndam = UUID.randomUUID().toString();
        user.setUid(ranndam);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    //get single user
    @Override
    public User getUser(String uid) {
        //get user from database with the help of user repositry
        User user = userRepository.findById(uid).orElseThrow(() -> new ResourseNotFoundException("User with " + uid + "not found on server !!"));
        //fetch rating of the above user from rating service
        //http://localhost:8087/ratings/users/9d3a7823-59ee-4d3a-a8d2-4853a2e8a2d8

        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + user.getUid(), Rating[].class);
        logger.info("{}", ratingsOfUser);
        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();

        List<Rating> ratingList = ratings.stream().map(rating -> {
            //api call to hotel service to get the hotel
            //http://localhost:8086/hotels/6347ab62-93dc-4b2e-99c7-25b497686964
//            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/" + rating.getHotelId(), Hotel.class);
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
//            logger.info("responce status code:{}", forEntity.getStatusCode());
            //set the hotel to rating
            rating.setHotel(hotel);
            //return the rating
            return rating;
        }).collect(Collectors.toList());
        user.setRatings(ratingList);
        return user;


    }
}
