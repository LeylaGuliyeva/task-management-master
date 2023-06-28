package com.task.management.api.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LoginRequest {
    @NotEmpty(message = "Customer's email cannot be empty.")
    private String email;

    @NotEmpty(message = "Customer's password cannot be empty.")
    private String password;
}
