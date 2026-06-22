package com.spring.jwt_auth.service;

import com.spring.jwt_auth.dto.RegisterRequest;
import com.spring.jwt_auth.entity.User;
import com.spring.jwt_auth.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String register(RegisterRequest request){

        if(userRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("Email Already Exists");
        }
        User user = new User(
                request.getEmail(),
                request.getPassword(),
                "USER"
        );
        userRepository.save(user);
        return "Registered Successfully!";
    }
}
