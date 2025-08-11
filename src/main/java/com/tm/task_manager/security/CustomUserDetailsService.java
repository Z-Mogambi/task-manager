package com.tm.task_manager.security;

import java.util.Collections;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import com.tm.task_manager.model.User;
import com.tm.task_manager.repo.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new org.springframework.security.core.userdetails.User(
                user.getUserName(),
                user.getPassword(),
                Collections.emptyList() // no roles for now
        );
    }
}
