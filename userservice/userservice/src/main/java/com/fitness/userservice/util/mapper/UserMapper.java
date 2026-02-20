package com.fitness.userservice.util.mapper;

import com.fitness.userservice.dto.RegisterRequest;
import com.fitness.userservice.dto.RegisterResponse;
import com.fitness.userservice.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    RegisterResponse toRegisterResponse(User user);

    User toEntity(RegisterRequest request);
}
