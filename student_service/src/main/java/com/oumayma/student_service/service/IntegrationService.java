package com.oumayma.student_service.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.oumayma.student_service.model.Account;
import com.oumayma.student_service.model.Invoice;

@Service
public class IntegrationService {

    private String financeBaseUrl = "http://finance-service:8081";
    private String financeCreateAccountEndpoint = "/accounts";
    private String financeCreateInvoiceEndpoint = "/invoices";
    private String financeGetAccountEndpoint = "/accounts/student/";
    private String libraryBaseUrl = "http://library-service:80";
    private String libraryCreateAccountEndpoint = "/api/register";

    @Autowired
    private RestTemplate restTemplate;

    public void createStudentAccounts(Account account) {
        // REQUIREMENT: when new user is created then create relevant accounts
        // in fincance and library micro services - PART 2
        restTemplate.postForObject(libraryBaseUrl + libraryCreateAccountEndpoint, account, Account.class);
        restTemplate.postForObject(financeBaseUrl + financeCreateAccountEndpoint, account, Account.class);
    }

    public Invoice generateCourseEnrolmentInvoice(Invoice invoice) {
        return restTemplate.postForObject(financeBaseUrl + financeCreateInvoiceEndpoint, invoice, Invoice.class);
    }

    public Account getStudentFinanceAccount(String studentId) {
        return restTemplate.getForObject(financeBaseUrl + financeGetAccountEndpoint + studentId, Account.class);
    }
}
