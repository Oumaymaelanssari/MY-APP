package com.oumayma.student_service.service;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import com.oumayma.student_service.model.*;
import com.oumayma.student_service.repository.EnrolmentRepository;
import com.oumayma.student_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Validated
@Component
public class EnrolmentService {

    @Autowired
    private EnrolmentRepository enrolmentRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Enrolment> getAllStudentEnrolments(String studentId) {
        User student = userRepository.findByStudentId(studentId);
        return enrolmentRepository.findByUser(student);
    }
}
