package com.fitness.userservice.dto;

import com.fitness.userservice.entity.UserRole;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponse {
    private String id;
    private String name;
    private String email;
    private String password;
    private UserRole role;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
