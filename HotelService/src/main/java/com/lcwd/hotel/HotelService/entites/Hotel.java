package com.lcwd.hotel.HotelService.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hotels")
public class Hotel {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String location;
    private String about;
}
