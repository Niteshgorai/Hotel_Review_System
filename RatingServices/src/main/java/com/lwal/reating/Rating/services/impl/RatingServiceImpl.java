package com.lwal.reating.Rating.services.impl;

import com.lwal.reating.Rating.entities.Rating;
import com.lwal.reating.Rating.repository.RatingRepository;
import com.lwal.reating.Rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepository ratingRepository;
    @Override
    public Rating create(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAll() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getByUserId(String UserId) {
        return ratingRepository.findByUserId(UserId);
    }

    @Override
    public List<Rating> getByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
}
