package com.oumayma.student_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/register").permitAll() // Allow everyone to access the registration page
                .anyRequest().authenticated() // Require authentication for any other request
                .and()
            .formLogin()
                //.loginPage("/login") // commented out in order to be
                //redirected to default Spring Security login page
                .permitAll()
                .defaultSuccessUrl("/", true) // Redirect to home page after login
                .and()
            .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // Configure logout endpoint
                .logoutSuccessUrl("/login?logout") // Redirect to login page after logout
                .permitAll();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
