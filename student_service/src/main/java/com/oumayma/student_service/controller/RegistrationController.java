package com.oumayma.student_service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.oumayma.student_service.model.User;
import com.oumayma.student_service.service.UserService;

@Controller // Use Controller instead of RestController for Thymeleaf templates
public class RegistrationController {

    //REQUIREMENT: manually crafted dependency injection (no Autowired used here)
    private UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/register")
    public ModelAndView showRegistrationForm() {
        ModelAndView mav = new ModelAndView("register");
        mav.addObject("user", new User());
        return mav;
    }

    @PostMapping("/register")
    public String registerUserAccount(User user) {
        userService.registerNewUserAccount(user);
        return "redirect:/login"; // Redirect to the login page after successful registration
    }
}

