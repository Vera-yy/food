package com.vera.apiResponse;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL) // Exclude null fields from JSON
public class ApiResponse<T> {
    private String status;
    private T data;
    private String message;
    private List<String> errors;

    // Default constructor
    public ApiResponse() {}

    public ApiResponse(String status, T data, String message, List<String> errors) {
        this.status = status;
        this.data = data;
        this.message = message;
        this.errors = errors;
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>("success", data, null, null);
    }

    public static <T> ApiResponse<T> error(String message, List<String> errors) {
        return new ApiResponse<>("error", null, message, errors);
    }

    // Getters and Setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}

