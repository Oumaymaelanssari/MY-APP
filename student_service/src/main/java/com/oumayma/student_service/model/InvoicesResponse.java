package com.oumayma.student_service.model;

import lombok.Data;
import lombok.Getter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@Data
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoicesResponse {

    @JsonProperty("_embedded")
    private EmbeddedInvoices embeddedInvoices;

    @Data
    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class EmbeddedInvoices {
        @JsonProperty("invoiceList")
        private List<Invoice> invoices;
    }
}

