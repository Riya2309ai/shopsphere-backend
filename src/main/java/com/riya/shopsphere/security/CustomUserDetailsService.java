package com.riya.shopsphere.security;

import com.riya.shopsphere.entity.User;
import com.riya.shopsphere.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         User user = userRepository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException(username));
         return new CustomUserDetails(user);
    }
}
