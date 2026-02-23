package com.fitness.activityservice.util.mapper;

import com.fitness.activityservice.dto.ActivityRequest;
import com.fitness.activityservice.dto.ActivityResponse;
import com.fitness.activityservice.model.Activity;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActivityMapper {

    ActivityResponse toRegisterResponse(Activity user);

    Activity toEntity(ActivityRequest request);

    ActivityResponse toActivityResponse(Activity user);
}
