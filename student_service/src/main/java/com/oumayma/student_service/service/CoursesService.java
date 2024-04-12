package com.oumayma.student_service.service;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.servlet.ModelAndView;
import com.oumayma.student_service.model.*;
import com.oumayma.student_service.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Validated
@Component
public class CoursesService {

    @Autowired
    private CoursesRepository coursesRepository;

    public List<Course> getAllCourses() {
        return coursesRepository.findAll();
    }

    public Course getCourse(Long courseId, User user) {
        return coursesRepository.findById(courseId).orElseThrow(IllegalStateException::new);
    }

}
