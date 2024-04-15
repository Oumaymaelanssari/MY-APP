package com.oumayma.student_service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.userdetails.UserDetails;
import com.oumayma.student_service.config.CustomUserDetails;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(@AuthenticationPrincipal CustomUserDetails user, Model model) {
        model.addAttribute("message", "Welcome to Student Service, " + user.getFirstname() + " " + user.getSurname() + "!");
        return "home"; // Name of the Thymeleaf template -> triggers file home.html
    }
}
