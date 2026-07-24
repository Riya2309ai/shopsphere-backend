package com.riya.shopsphere.controller;

import com.riya.shopsphere.dto.LoginRequest;
import com.riya.shopsphere.dto.LoginResponse;
import com.riya.shopsphere.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest  loginRequest) {
        //ToDo

        return new LoginResponse();
    }
}
