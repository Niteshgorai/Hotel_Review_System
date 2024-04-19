package com.lcwd.hotel.HotelService.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String s){
        super(s);
    }
    public ResourceNotFoundException(){
        super("resource not found");
    }
}
