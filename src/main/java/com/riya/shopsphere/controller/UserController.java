package com.riya.shopsphere.controller;

import com.riya.shopsphere.dto.UserRequest;
import com.riya.shopsphere.dto.UserResponse;
import com.riya.shopsphere.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@Valid @RequestBody UserRequest userRequest){
        System.out.println("Controller reached");
        UserResponse userResponse = userService.registerUser(userRequest);

        return ResponseEntity.ok(userResponse);
    }

}
