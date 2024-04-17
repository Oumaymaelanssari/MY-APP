package com.oumayma.student_service.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.oumayma.student_service.model.Enrolment;
import com.oumayma.student_service.model.User;
import com.oumayma.student_service.repository.EnrolmentRepository;
import com.oumayma.student_service.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

public class EnrolmentServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private EnrolmentRepository enrolmentRepository;

    @InjectMocks
    private EnrolmentService enrolmentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllStudentEnrolments_whenUserExists_returnsEnrolments() {
        String studentId = "123";
        User user = new User();
        user.setStudentId(studentId);
        List<Enrolment> expectedEnrolments = Arrays.asList(new Enrolment(), new Enrolment());

        when(userRepository.findByStudentId(studentId)).thenReturn(user);
        when(enrolmentRepository.findByUser(user)).thenReturn(expectedEnrolments);

        List<Enrolment> actualEnrolments = enrolmentService.getAllStudentEnrolments(studentId);

        assertEquals(expectedEnrolments, actualEnrolments);
        verify(userRepository).findByStudentId(studentId);
        verify(enrolmentRepository).findByUser(user);
    }

    @Test
    void getAllStudentEnrolments_whenUserDoesNotExist_returnsEmptyList() {
        String studentId = "unknown";
        when(userRepository.findByStudentId(studentId)).thenReturn(null);

        List<Enrolment> actualEnrolments = enrolmentService.getAllStudentEnrolments(studentId);

        assertEquals(0, actualEnrolments.size());
        verify(userRepository).findByStudentId(studentId);
        verify(enrolmentRepository, never()).findByUser(any(User.class));
    }
}
