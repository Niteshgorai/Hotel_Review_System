package com.Spring.User.Service.UserService.externel.services;

import com.Spring.User.Service.UserService.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Service
@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    //get

    //post
    @PostMapping("/ratings")
    Rating createRating(Rating values);

    //put
    @PutMapping("/ratings/{ratingId}")
    Rating updateRating(@PathVariable("ratingId") String ratingId, Rating rating);

    //delete
    @DeleteMapping("/rating/{ratingId}")
    Rating deleterating(@PathVariable String ratingId);
}
