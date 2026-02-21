package com.fitness.userservice.controller;

import com.fitness.userservice.dto.RegisterRequest;
import com.fitness.userservice.dto.RegisterResponse;
import com.fitness.userservice.dto.UserResponse;
import com.fitness.userservice.entity.User;
import com.fitness.userservice.services.UserService;
import com.fitness.userservice.util.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Log4j2
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> getUserById(@PathVariable String id) {
        log.info("find user req, id: {}", id);

        UserResponse response = userService.findUserById(id);
        log.info("find user by id response : {}", response);
        return ResponseEntity.ok(ApiResponse.success(response));
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<?>> addUser(@Valid @RequestBody RegisterRequest req) {
        log.debug("User Registration Request: {} ", req);

        RegisterResponse response = userService.register(req);
        log.info("response: {}", response);
        return ResponseEntity.ok(ApiResponse.success(response));
    }

}
