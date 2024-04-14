package com.oumayma.student_service.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
// getters and setters will be automatically generated
@Getter
@Setter
@NoArgsConstructor
public class Enrolment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="studentId", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name="courseId", nullable = false)
    private Course course;

    public Enrolment(User user, Course course) {
        this.user = user;
        this.course = course;
    }
}
