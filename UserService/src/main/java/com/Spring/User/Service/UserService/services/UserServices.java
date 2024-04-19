package com.Spring.User.Service.UserService.services;

import com.Spring.User.Service.UserService.entities.User;
import com.Spring.User.Service.UserService.exception.ResourseNotFoundException;

import java.util.List;

public interface UserServices {
    User saveUser(User user);

    List<User> getAllUser();

    User getUser(String uid) throws ResourseNotFoundException;
}
