package com.task.management.api.service.impl;

import com.task.management.api.models.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRespository taskRepository;
    public Task createTask(Task requestModel){
        return taskRepository.save(requestModel);
    }
    public Task updateTask(Long taskId, Task requestModel){
        Task task = taskRepository.findById(taskId);
        task.settitle(requestModel.getTitle());
        task.setDescription(requestModel.getDescription());
        task.setStatus(requestModel.getStatus());
        task.setAssignee(requestModel.getAssignee());
        return taskRepository.save(task);
    }
    public Task updateTaskFields(Long taskId, Task requestModel){
        Task task = taskRepository.findById(taskId);
        task.settitle(requestModel.getTitle());
        task.setDescription(requestModel.getDescription());
        task.setStatus(requestModel.getStatus());
        task.setAssignee(requestModel.getAssignee());
        return taskRepository.save(task);

    }
    public String deleteTask(Long taskId){
        taskRepository.deleteById(id);
    }
}