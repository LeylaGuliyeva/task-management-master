package com.task.management.api.repository;

import com.task.management.api.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Task findById(Long id);
}
