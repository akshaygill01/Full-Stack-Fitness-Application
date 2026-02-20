package com.fitness.userservice.services;

import com.fitness.userservice.dto.RegisterRequest;
import com.fitness.userservice.dto.RegisterResponse;
import com.fitness.userservice.entity.User;
import com.fitness.userservice.repository.UserRepository;
import com.fitness.userservice.util.mapper.UserMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Log4j2
public class UserService {

    private UserRepository userRepository;
    private UserMapper mapper;

    public RegisterResponse register(RegisterRequest req) {

        if(userRepository.existsByEmail(req.getEmail())){
            throw new RuntimeException("Email already exists");
        }

        User user = mapper.toEntity(req);
        User savedUser = userRepository.save(user);
        log.info("User registered successfully, {} ", savedUser);
        return mapper.toRegisterResponse(savedUser);
    }
}
