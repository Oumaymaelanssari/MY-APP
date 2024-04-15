package com.oumayma.student_service.service;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import com.oumayma.student_service.model.*;
import com.oumayma.student_service.repository.CoursesRepository;
import com.oumayma.student_service.repository.EnrolmentRepository;
import com.oumayma.student_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.time.LocalDate;

@Validated
@Component
public class CoursesService {

    @Autowired
    private CoursesRepository coursesRepository;
    @Autowired
    private EnrolmentRepository enrolmentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private IntegrationService integrationService;

    public List<Course> getAllCourses() {
        return coursesRepository.findAll();
    }

    public Course getCourse(Long courseId, User user) {
        return coursesRepository.findById(courseId).orElseThrow(IllegalStateException::new);
    }

    public List<Long> getStudentEnrolledCourseIds(String studentId) {
        return enrolmentRepository.findEnrolledCourseIdsByStudentId(studentId);
    }

    public void enrolStudentToCourse(String studentId, Long courseId) {
        User student = userRepository.findByStudentId(studentId);
        Course course = coursesRepository.findById(courseId).orElseThrow(IllegalStateException::new);

        // saving enrolment in the database
        Enrolment enrolment = new Enrolment();
        enrolment.setUser(student);
        enrolment.setCourse(course);
        enrolmentRepository.save(enrolment);

        // REQUIREMENT: when new user is enroled to the service Invoice is
        // generated in finance_service
        this.generateCourseInvoiceInFinanceService(studentId, course);
    }

    private void generateCourseInvoiceInFinanceService(String studentId, Course course){
        Account account = new Account();
        account.setStudentId(studentId);

        Invoice invoice = new Invoice();
        invoice.setAccount(account);
        invoice.setType(Invoice.Type.TUITION_FEES);
        invoice.setAmount(course.getCost());
        invoice.setDueDate(LocalDate.now().plusWeeks(3));

        integrationService.generateCourseEnrolmentInvoice(invoice);
    }
}

