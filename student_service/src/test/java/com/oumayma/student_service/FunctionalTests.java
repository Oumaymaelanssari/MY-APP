package com.oumayma.student_service.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.hamcrest.Matchers.containsString;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.security.test.context.support.WithMockUser;

import com.oumayma.student_service.config.CustomUserDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;
import java.util.Arrays;

import com.oumayma.student_service.model.*;
import com.oumayma.student_service.service.CoursesService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class FunctionalTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CoursesService coursesService;

    @BeforeEach
    public void setupSecurityContext() {
        CustomUserDetails userDetails = new CustomUserDetails("user", "password", "user@example.com", "Firstname", "Surname", "c01234567", Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
        Authentication auth = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    @AfterEach
    public void clearSecurityContext() {
        SecurityContextHolder.clearContext();
    }

    @Test
    @WithMockUser(username = "user", password = "password", roles = "USER")
    public void testHomePage() throws Exception {
        this.mockMvc.perform(get("/"))
                    .andExpect(status().isOk())
                    .andExpect(view().name("home"))
                    .andExpect(content().string(containsString("Welcome")));
    }

    @Test
    @WithMockUser(username = "user", password = "password", roles = "USER")
    public void testCoursesPage() throws Exception {
        String studentId = "c01234567"; // Assuming the ID of the logged in user
        List<Course> coursesList = Arrays.asList(new Course(), new Course());
        List<Long> enrolledCoursesIds = Arrays.asList(1L);

        when(coursesService.getAllCourses()).thenReturn(coursesList);
        when(coursesService.getStudentEnrolledCourseIds(studentId)).thenReturn(enrolledCoursesIds);

        mockMvc.perform(MockMvcRequestBuilders.get("/courses"))
               .andExpect(status().isOk())
               .andExpect(view().name("courses"))
               .andExpect(model().attribute("courses", coursesList))
               .andExpect(model().attribute("enrolledCoursesIds", enrolledCoursesIds));
        
        verify(coursesService).getAllCourses();
        verify(coursesService).getStudentEnrolledCourseIds(studentId);
    }

}
