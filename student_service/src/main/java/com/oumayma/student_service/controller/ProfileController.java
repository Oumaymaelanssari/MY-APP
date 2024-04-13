package com.oumayma.student_service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.oumayma.student_service.model.User;
import com.oumayma.student_service.config.CustomUserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import com.oumayma.student_service.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);

    @RequestMapping("/profile")
    public ModelAndView courses(@AuthenticationPrincipal CustomUserDetails user) {
        ModelAndView modelAndView = new ModelAndView("profile");
        //User user = profileService.getProfile();
        modelAndView.addObject("profile_user", user);
        return modelAndView;
    }

    @GetMapping("/editProfile")
    public ModelAndView editProfileGet(@AuthenticationPrincipal CustomUserDetails user) {
        ModelAndView modelAndView = new ModelAndView("edit-profile");
        modelAndView.addObject("profile_user", user);
        return modelAndView;
    }

    @PostMapping("/editProfile")
    public ModelAndView editProfile(CustomUserDetails user) {
        ModelAndView modelAndView = new ModelAndView("profile");
        CustomUserDetails edited_user = profileService.editProfile(user);

        // reauthenticate user in order the edited data will be visible in
        // authenticated profile and on the web pages
        Authentication currentAuth = SecurityContextHolder.getContext().getAuthentication();
        Authentication newAuth = new UsernamePasswordAuthenticationToken(edited_user, currentAuth.getCredentials(), edited_user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(newAuth);

        modelAndView.addObject("profile_user", edited_user);
        return modelAndView;
    }
}
