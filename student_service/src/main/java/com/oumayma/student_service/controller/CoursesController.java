package com.oumayma.student_service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.oumayma.student_service.model.User;
import com.oumayma.student_service.model.Course;
import com.oumayma.student_service.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import com.oumayma.student_service.config.CustomUserDetails;

import java.util.List;

@Controller
public class CoursesController {

    @Autowired
    private CoursesService coursesService;

    @RequestMapping("/courses")
    public ModelAndView courses(@AuthenticationPrincipal CustomUserDetails student) {
        ModelAndView modelAndView = new ModelAndView("courses");

        List<Course> courses = coursesService.getAllCourses();
        List<Long> enrolledCoursesIds = coursesService.getStudentEnrolledCourseIds(student.getStudentId());

        modelAndView.addObject("courses", courses);
        modelAndView.addObject("enrolledCoursesIds", enrolledCoursesIds);
        return modelAndView;
    }

    @GetMapping("/courses/{courseId}/enrol")
    public String enrolStudentToCourse(@PathVariable Long courseId, @AuthenticationPrincipal CustomUserDetails student) {
        coursesService.enrolStudentToCourse(student.getStudentId(), courseId);
        return "redirect:/courses"; // Redirect back to up-to-date /courses page
    }
}
