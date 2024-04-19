package com.lwal.reating.Rating.controller;

import com.lwal.reating.Rating.entities.Rating;
import com.lwal.reating.Rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    //create rating
    @PreAuthorize("hasAuthrity('Admin')")
    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
    }

    //getAll
    @GetMapping
    public ResponseEntity<List<Rating>> getRating() {
        return ResponseEntity.ok(ratingService.getAll());
    }

    //get all rating of user
    @PreAuthorize("hasAuthority('SCOPE_internal') ||hasAuthrity('Admin')")
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(ratingService.getByUserId(userId));
    }

    //get all rating of hotel
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getByHotelId(@PathVariable String hotelId) {
        return ResponseEntity.ok(ratingService.getByHotelId(hotelId));
    }
}
