package com.task.management.api.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class TaskResponse {
    private final Long id;
    private final String title;
    private final String description;
    private final LocalDate createDate;
    private final LocalDate dueDate;
    private final String status;
    private final CustomerResponse assignee;
}
