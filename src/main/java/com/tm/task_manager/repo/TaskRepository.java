package com.tm.task_manager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tm.task_manager.model.Task;


public interface TaskRepository extends JpaRepository<Task, Long> {
}
