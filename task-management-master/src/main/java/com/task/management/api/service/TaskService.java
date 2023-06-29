package com.task.management.api.service;

import com.task.management.api.entity.Task;

public interface TaskService{
        Task createTask(Task requestModel);
        Task updateTask(Long taskId, Task requestModel);
        void deleteTask(Long taskId);
        Task findAdvanced(Task requestModel);
}