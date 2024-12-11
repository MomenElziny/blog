package com.example.blog.service;

import com.example.blog.dto.RegistrationDto;
import com.example.blog.model.User;

public interface UserService {
 void saveUser(RegistrationDto registrationDto);

    User findByEmail(String email);
}
