package com.task.management.api.controller;

import com.task.management.api.adapter.WebAdapter;
import com.task.management.api.dto.TaskRequest;
import com.task.management.api.dto.TaskResponse;
import com.task.management.api.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TaskApiImpl implements TaskApi {
    private final WebAdapter adapter;
    private final TaskService service;

    @Override
    public ResponseEntity<TaskResponse> createTask(TaskRequest requestModel) {
        return ResponseEntity.ok(adapter.map(service.createTask(adapter.map(requestModel))));
    }

    @Override
    public ResponseEntity<TaskResponse> updateTask(Long taskId, TaskRequest requestModel) {
        return ResponseEntity.ok(adapter.map(service.updateTask(taskId, adapter.map(requestModel))));
    }

    @Override
    public ResponseEntity<?> deleteTask(Long taskId) {
        service.deleteTask(taskId);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<TaskResponse> findAdvanced(TaskRequest requestModel) {
        return ResponseEntity.ok(adapter.map(service.findAdvanced(adapter.map(requestModel))));
    }
}