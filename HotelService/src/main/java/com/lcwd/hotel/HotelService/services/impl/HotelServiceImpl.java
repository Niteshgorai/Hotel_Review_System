package com.lcwd.hotel.HotelService.services.impl;
import com.lcwd.hotel.HotelService.entites.Hotel;
import com.lcwd.hotel.HotelService.exception.ResourceNotFoundException;
import com.lcwd.hotel.HotelService.repositories.HotelRepositorie;
import com.lcwd.hotel.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepositorie hotelRepositorie;
    @Override
    public Hotel create(Hotel hotel) {
        String hotelId= UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelRepositorie.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepositorie.findAll();
    }

    @Override
    public Hotel get(String id) {
        return hotelRepositorie.findById(id).orElseThrow(()-> new ResourceNotFoundException("hotel with given id not found!!"));
    }
}
