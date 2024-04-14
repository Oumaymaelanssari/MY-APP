package com.oumayma.student_service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.oumayma.student_service.config.CustomUserDetails;
import com.oumayma.student_service.model.Enrolment;
import com.oumayma.student_service.service.EnrolmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.util.List;

@Controller
public class EnrolmentController {

    @Autowired
    private EnrolmentService enrolmentService;

    @RequestMapping("/enrolments")
    public ModelAndView enrolments(@AuthenticationPrincipal CustomUserDetails user) {
        ModelAndView modelAndView = new ModelAndView("enrolments");
        String studentId = user.getStudentId();
        List<Enrolment> enrolments = enrolmentService.getAllStudentEnrolments(studentId);
        modelAndView.addObject("enrolments", enrolments);
        return modelAndView;
    }
}
