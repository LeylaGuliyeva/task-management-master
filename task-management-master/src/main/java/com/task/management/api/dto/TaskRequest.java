package com.task.management.api.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskRequest {
    @NotEmpty(message = "Task's title cannot be empty.")
    private final String title;
    private final String description;

    @NotEmpty(message = "Task's createDate cannot be empty.")
    private final LocalDate createDate;
    private final LocalDate dueDate;

    @NotEmpty(message = "Task's status cannot be empty.")
    private final String status;
    private final CustomerRequest assignee;
}
