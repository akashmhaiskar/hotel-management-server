package com.practiceproject.HotelServer.services.auth;

import com.practiceproject.HotelServer.dtos.SignupRequest;
import com.practiceproject.HotelServer.dtos.UserDto;

public interface AuthService {

    UserDto createUser(SignupRequest signupRequest);
}
