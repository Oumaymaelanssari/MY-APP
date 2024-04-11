package com.oumayma.student_service.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.oumayma.student_service.model.Account;

@Service
public class IntegrationService {

    private String financeBaseUrl = "http://finance-service:8081";
    private String financeCreateEndpoint = "/accounts";
    private String libraryBaseUrl = "http://library-service:80";
    private String libraryCreateEndpoint = "/api/register";

    @Autowired
    private RestTemplate restTemplate;

    public void createStudentAccounts(Account account) {
        // REQUIREMENT: when new user is created then create relevant accounts
        // in fincance and library micro services - PART 2
        restTemplate.postForObject(libraryBaseUrl + libraryCreateEndpoint, account, Account.class);
        restTemplate.postForObject(financeBaseUrl + financeCreateEndpoint, account, Account.class);
    }
}
