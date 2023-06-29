package com.task.management.api.service.impl;

import com.task.management.api.entity.Task;
import com.task.management.api.repository.TaskRepository;
import com.task.management.api.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task requestModel) {
        return taskRepository.save(requestModel);
    }

    public Task updateTask(Long taskId, Task requestModel) {
        Task task = taskRepository.findById(taskId).get();
        task.setTitle(requestModel.getTitle());
        task.setDescription(requestModel.getDescription());
        task.setStatus(requestModel.getStatus());
        task.setAssignee(requestModel.getAssignee());
        return taskRepository.save(task);
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    public Task findAdvanced(Task requestModel) {
        return null;
    }
}