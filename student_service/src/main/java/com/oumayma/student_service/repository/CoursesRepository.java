package com.oumayma.student_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.oumayma.student_service.model.Course;

public interface CoursesRepository extends JpaRepository<Course, Long> {}
