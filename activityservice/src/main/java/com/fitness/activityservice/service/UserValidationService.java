package com.fitness.activityservice.service;

import com.fitness.activityservice.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserValidationService {

    private final WebClient userServiceWebClient;

    public boolean isUserValid(String userId) {

        ApiResponse<Boolean> response = null;
        try {
            response = userServiceWebClient.get()
                            .uri("/api/users/{userId}/validate", userId)
                            .retrieve()
                            .bodyToMono(new ParameterizedTypeReference<ApiResponse<Boolean>>() {})
                            .block();

        } catch (WebClientException e) {
            throw new RuntimeException(e);
        }

        return response != null && Boolean.TRUE.equals(response.getData());
    }
}
