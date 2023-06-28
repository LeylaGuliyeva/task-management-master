package com.task.management.api.controller;

import com.task.management.api.adapter.WebAdapter;
import com.task.management.api.dto.TaskRequest;
import com.task.management.api.dto.TaskResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TaskApiImpl implements TaskApi {
    private final WebAdapter adapter;

    @Override
    public ResponseEntity<TaskResponse> createTask(TaskRequest requestModel) {
        return ResponseEntity.ok(null); // call adapter.map() methods to convert
        // requestModel to Entity, then from Entity to Response
    }

    @Override
    public ResponseEntity<TaskResponse> updateTask(Long taskId, TaskRequest requestModel) {
        return ResponseEntity.ok(null); // call adapter.map() methods to convert
        // requestModel to Entity, then from Entity to Response
    }

    @Override
    public ResponseEntity<TaskResponse> updateTaskFields(Long taskId, TaskRequest requestModel) {
        return ResponseEntity.ok(null); // call adapter.map() methods to convert
        // requestModel to Entity, then from Entity to Response
    }

    @Override
    public ResponseEntity<String> deleteTask(Long taskId) {
        return ResponseEntity.ok("Hello");
    }

    @Override
    public ResponseEntity<TaskResponse> findAdvanced(TaskRequest requestModel) {
        return ResponseEntity.ok(null); // call adapter.map() methods to convert
        // requestModel to Entity, then from Entity to Response
    }
}
