package com.lcwd.hotel.HotelService.services;

import com.lcwd.hotel.HotelService.entites.Hotel;


import java.util.List;

public interface HotelService {
    //create
    Hotel create(Hotel hotel);

    //get all
    List<Hotel> getAll();

    //get single
    Hotel get(String id);
}
