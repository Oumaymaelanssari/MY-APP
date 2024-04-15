package com.oumayma.student_service.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Invoice {
    public enum Type {
        LIBRARY_FINE,
        TUITION_FEES
    }

    enum Status {
        OUTSTANDING,
        PAID,
        CANCELLED
    }

    // the Invoice definition here must be aligned with finance service invoice 
    // definition which is here: https://github.com/tvergilio/finance/blob/master/src/main/java/uk/ac/leedsbeckett/finance/model/Invoice.java
    private Long id;
    private String reference;
    private Double amount;
    private LocalDate dueDate;
    private Type type;
    private Status status;
    private Account account;
}
