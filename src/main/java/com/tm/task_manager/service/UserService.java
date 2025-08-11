package com.tm.task_manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tm.task_manager.model.User;
import com.tm.task_manager.repo.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        //just saving. mo pwd encoding
        return userRepository.save(user);
    }
}
