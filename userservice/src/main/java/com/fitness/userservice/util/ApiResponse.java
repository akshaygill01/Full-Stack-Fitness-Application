package com.fitness.userservice.util;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class ApiResponse<T> {

    private String status;
    private String message;
    private T data;

    // Private constructor
    private ApiResponse() {
    }

    // All args constructor
    private ApiResponse(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>("SUCCESS", "Request successful", data);
    }

    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>("SUCCESS", message, data);
    }

    public static <T> ApiResponse<T> success(String message) {
        return new ApiResponse<>("SUCCESS", message, null);
    }

    public static <T> ApiResponse<T> failure(String message) {
        return new ApiResponse<>("FAILED", message, null);
    }

    public static <T> ApiResponse<T> failure(String message, T data) {
        return new ApiResponse<>("FAILED", message, data);
    }

}
