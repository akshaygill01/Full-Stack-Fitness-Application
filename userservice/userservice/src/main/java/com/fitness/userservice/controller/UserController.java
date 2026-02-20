package com.fitness.userservice.controller;

import com.fitness.userservice.dto.RegisterRequest;
import com.fitness.userservice.dto.RegisterResponse;
import com.fitness.userservice.services.UserService;
import com.fitness.userservice.util.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Log4j2
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<?>> addUser( @Valid @RequestBody RegisterRequest req) {
         log.debug("User Registration Request: {} ", req);

         RegisterResponse response = userService.register(req);
         log.info("response: {}", response);
         return ResponseEntity.ok(ApiResponse.success(response));
    }

}
