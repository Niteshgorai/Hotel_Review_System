package com.lwal.reating.Rating.services;

import com.lwal.reating.Rating.entities.Rating;

import java.sql.ClientInfoStatus;
import java.util.List;

public interface RatingService {

    //CREATE
     Rating create(Rating rating);

    //get all
    List<Rating> getAll();

    //get by UserId
    List<Rating> getByUserId(String UserId);

    //get by hotel
    List<Rating> getByHotelId(String hotelId);

}
