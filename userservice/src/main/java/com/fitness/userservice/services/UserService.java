package com.fitness.userservice.services;

import com.fitness.userservice.dto.RegisterRequest;
import com.fitness.userservice.dto.RegisterResponse;
import com.fitness.userservice.dto.UserResponse;
import com.fitness.userservice.entity.User;
import com.fitness.userservice.repository.UserRepository;
import com.fitness.userservice.util.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;

    public RegisterResponse register(RegisterRequest req) {

        if(userRepository.existsByEmail(req.getEmail())){
            throw new RuntimeException("Email already exists");
        }

        User user = mapper.toEntity(req);
        User savedUser = userRepository.save(user);
        log.info("User registered successfully, {} ", savedUser);
        return mapper.toRegisterResponse(savedUser);
    }

    public UserResponse findUserById(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        return mapper.toUserResponse(user);
    }

    public boolean existsById(String id) {
        return userRepository.existsById(id);
    }
}
