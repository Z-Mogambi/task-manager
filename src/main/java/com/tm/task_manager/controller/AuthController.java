package com.tm.task_manager.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.tm.task_manager.model.User;
// import com.tm.task_manager.service.UserService;

// @RestController
// @RequestMapping("/api/auth")
// public class AuthController {

//     @Autowired 
//     private UserService userService;

//     @PostMapping("/register")
//     public String register(@RequestBody User user) {
//         userService.registerUser(user);
//         return "User registered successfully!";
//     }
// }

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tm.task_manager.model.User;
import com.tm.task_manager.repo.UserRepository;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired private UserRepository userRepository;
    @Autowired private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
