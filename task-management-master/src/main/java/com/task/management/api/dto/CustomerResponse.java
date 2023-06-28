package com.task.management.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerResponse {
    private final Long id;
    private final String name;
    private final String surname;
    private final Integer age;
    private final String email;
    private final String password;
}
