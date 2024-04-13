package com.oumayma.student_service.service;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.servlet.ModelAndView;
import com.oumayma.student_service.model.*;
import com.oumayma.student_service.repository.UserRepository;
import com.oumayma.student_service.config.CustomUserDetails;
import com.oumayma.student_service.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Validated
@Component
public class ProfileService {

    @Autowired
    private UserRepository userRepository;

    public CustomUserDetails editProfile(CustomUserDetails user) {
        // update edited user data in the database
        User edited_user = userRepository.findByUsername(user.getUsername());
        edited_user.setFirstname(user.getFirstname());
        edited_user.setSurname(user.getSurname());
        userRepository.saveAndFlush(edited_user);

        
        return user;
    }

}

