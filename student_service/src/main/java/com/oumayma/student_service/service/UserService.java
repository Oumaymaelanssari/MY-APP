package com.oumayma.student_service.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.oumayma.student_service.config.CustomUserDetails;
import com.oumayma.student_service.repository.UserRepository;
import com.oumayma.student_service.model.User;
import com.oumayma.student_service.model.Account;
import com.oumayma.student_service.service.IntegrationService;

import java.util.ArrayList;


@Service
public class UserService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    //REQUIREMENT: automated dependency injection using Autowired annotation
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IntegrationService integrationService;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("loadUserByUsername: " + username);
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found.");
        }
        return new CustomUserDetails(user.getUsername(), user.getPassword(), user.getEmail(), user.getFirstname(), user.getSurname(), user.getStudentId(), new ArrayList<>());
    }

    public User registerNewUserAccount(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.createStudentId();
        // REQUIREMENT: when new user is created then create relevant accounts
        // in fincance and library micro services - PART 1
        this.createStudentAccounts(user);
        return userRepository.save(user);
    }

    private void createStudentAccounts(User user) {
        Account account = new Account();
        account.setStudentId(user.getStudentId());
        integrationService.createStudentAccounts(account);
    }
}
