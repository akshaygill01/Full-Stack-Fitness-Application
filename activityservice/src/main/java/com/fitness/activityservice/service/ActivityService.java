package com.fitness.activityservice.service;

import com.fitness.activityservice.dto.ActivityRequest;
import com.fitness.activityservice.dto.ActivityResponse;
import com.fitness.activityservice.model.Activity;
import com.fitness.activityservice.repository.ActivityRepository;
import com.fitness.activityservice.util.mapper.ActivityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;
    private final ActivityMapper mapper;

    public ActivityResponse trackActivity(ActivityRequest request) {

        Activity activity = mapper.toEntity(request);

        Activity savedActivity = activityRepository.save(activity);

        return mapper.toActivityResponse(savedActivity);
    }
}
