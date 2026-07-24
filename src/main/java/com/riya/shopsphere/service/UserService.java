package com.riya.shopsphere.service;

import com.riya.shopsphere.dto.LoginRequest;
import com.riya.shopsphere.dto.LoginResponse;
import com.riya.shopsphere.dto.UserRequest;
import com.riya.shopsphere.dto.UserResponse;

public interface UserService {
    UserResponse registerUser(UserRequest userRequest);

    LoginResponse login(LoginRequest loginRequest);
}
