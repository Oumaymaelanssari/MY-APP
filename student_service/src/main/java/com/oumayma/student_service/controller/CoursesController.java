package com.oumayma.student_service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.oumayma.student_service.model.User;
import com.oumayma.student_service.model.Course;
import com.oumayma.student_service.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Controller
public class CoursesController {

    @Autowired
    private CoursesService coursesService;

    @RequestMapping("/courses")
    public ModelAndView courses() {
        ModelAndView modelAndView = new ModelAndView("courses");
        List<Course> courses = coursesService.getAllCourses();
        modelAndView.addObject("courses", courses);
        return modelAndView;
    }
}
