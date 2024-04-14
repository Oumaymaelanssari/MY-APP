package com.oumayma.student_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.oumayma.student_service.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByUsername(String username);
    User findByStudentId(String studentId);
}
