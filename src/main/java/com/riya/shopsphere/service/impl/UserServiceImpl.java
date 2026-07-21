package com.riya.shopsphere.service.impl;

import com.riya.shopsphere.dto.UserRequest;
import com.riya.shopsphere.dto.UserResponse;
import com.riya.shopsphere.entity.User;
import com.riya.shopsphere.enums.Role;
import com.riya.shopsphere.exception.EmailAlreadyExistsException;
import com.riya.shopsphere.repository.UserRepository;
import com.riya.shopsphere.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse registerUser(UserRequest userRequest) {

        Optional<User> existingUser = userRepository.findByEmail(userRequest.getEmail());

        User user = new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setRole(Role.CUSTOMER);

        if(existingUser.isPresent()){
            throw new EmailAlreadyExistsException("User with email already exists");
        }
        User savedUser = userRepository.save(user);

        UserResponse userResponse = new UserResponse();

        userResponse.setId(savedUser.getId());
        userResponse.setName(savedUser.getName());
        userResponse.setEmail(savedUser.getEmail());
        userResponse.setRole(savedUser.getRole());

        return userResponse;
    }
}
