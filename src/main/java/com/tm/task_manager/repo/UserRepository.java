package com.tm.task_manager.repo;

// import java.util.Optional;
// import org.springframework.data.jpa.repository.JpaRepository;
// import com.tm.task_manager.model.User;

// public interface UserRepository extends JpaRepository<User, Long> {
//     Optional<User> findByUserName(String userName);
// }

import org.springframework.data.jpa.repository.JpaRepository;
import com.tm.task_manager.model.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String userName);
}