package com.oumayma.student_service.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.apache.commons.lang3.RandomStringUtils;

// thanks to the Entity annotation db tables will be automatically generated
@Entity
// getters and setters will be automatically generated
@Getter
@Setter
@NoArgsConstructor
@Table(name="portal_user") // 'user' is reserved keyword - rename table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String username;
    @Column(nullable = false, unique = true, length = 60)
    private String email;
    @Column(nullable = false, unique = true, length = 60)
    private String password;
    @Column(nullable = true, unique = true, length = 8)
    private String studentId;
    @Column(nullable = true, unique = true, length = 30)
    private String firstname;
    @Column(nullable = true, unique = true, length = 30)
    private String surname;

    public void createStudentId() {
        if (this.studentId == null) {
            this.studentId = "c" +
                    RandomStringUtils.random(1, '7', '3') +
                    RandomStringUtils.randomNumeric(6);
        }
    }
}

