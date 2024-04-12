package com.oumayma.student_service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
// getters and setters will be automatically generated
@Getter
@Setter
@NoArgsConstructor
public class Course {
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String title;
    @Column(length = 1000)
    private String description;
    private Double cost;
}
