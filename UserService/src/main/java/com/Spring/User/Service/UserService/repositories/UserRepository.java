package com.Spring.User.Service.UserService.repositories;

import com.Spring.User.Service.UserService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
