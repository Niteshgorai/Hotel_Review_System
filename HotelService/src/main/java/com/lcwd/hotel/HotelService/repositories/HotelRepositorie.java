package com.lcwd.hotel.HotelService.repositories;

import com.lcwd.hotel.HotelService.entites.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepositorie extends JpaRepository<Hotel, String> {
}
