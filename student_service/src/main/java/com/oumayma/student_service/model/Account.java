package com.oumayma.student_service.model;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {
    private Long id;
    private String studentId;
    private boolean hasOutstandingBalance;
}
