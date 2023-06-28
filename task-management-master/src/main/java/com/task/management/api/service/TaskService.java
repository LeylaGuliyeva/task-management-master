package com.task.management.api.service;
import com.task.management.api.models.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

public interface TaskService{
        Task createTask(Task requestModel);
        Task updateTask(Long taskId, Task requestModel);
        Task updateTaskFields(Long taskId, Task requestModel);
        String deleteTask(Long taskId);
}