package com.task.management.api.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CustomerRequest {
    @NotEmpty(message = "Customer's name cannot be empty.")
    private String name;

    @NotEmpty(message = "Customer's surname cannot be empty.")
    private String surname;

    @NotNull(message = "Customer's age cannot be null.")
    private Integer age;

    @NotEmpty(message = "Customer's email cannot be empty.")
    private String email;

    @NotEmpty(message = "Customer's password cannot be empty.")
    private String password;
}
