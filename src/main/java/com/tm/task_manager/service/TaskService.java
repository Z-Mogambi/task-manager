package com.tm.task_manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.task_manager.model.Task;
import com.tm.task_manager.model.User;
import com.tm.task_manager.repo.TaskRepository;
import com.tm.task_manager.repo.UserRepository;

@Service
public class TaskService {
    @Autowired private TaskRepository taskRepo;
    @Autowired private UserRepository userRepo;

    public Task createTask(Long userId, Task task) {
        User user = userRepo.findById(userId).orElseThrow();
        task.setUser(user);
        return taskRepo.save(task);
    }
}