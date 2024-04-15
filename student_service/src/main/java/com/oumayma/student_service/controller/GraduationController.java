package com.oumayma.student_service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.oumayma.student_service.model.Account;
import com.oumayma.student_service.model.Invoice;
import com.oumayma.student_service.config.CustomUserDetails;
import com.oumayma.student_service.service.IntegrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class GraduationController {

    @Autowired
    private IntegrationService integrationService;

    @RequestMapping("/graduation")
    public ModelAndView graduation(@AuthenticationPrincipal CustomUserDetails student) {

        //TODO - move the below functions logic to separate GraduationService
        boolean isEligableToGraduate = getEligableToGraduateStatus(student.getStudentId());

        ModelAndView modelAndView = new ModelAndView("check-graduation");
        modelAndView.addObject("isEligableToGraduate", isEligableToGraduate);
        if (isEligableToGraduate) {
            modelAndView.addObject("graduationStatusMessage", "ELIGABLE TO GRADUATE");
        } else {
            List<Invoice> outstandingInvoices = getOutstandingInvoices(student.getStudentId());
            modelAndView.addObject("graduationStatusMessage", "NOT ELIGABLE TO GRADUATE");
            modelAndView.addObject("outstandingInvoices", outstandingInvoices);
        }
        return modelAndView;

    }

    private boolean getEligableToGraduateStatus(String studentId) {
        Account account = integrationService.getStudentFinanceAccount(studentId);
        boolean isEligableToGraduate = !account.isHasOutstandingBalance();
        return isEligableToGraduate;
    }

    private List<Invoice> getOutstandingInvoices(String studentId) {
        List<Invoice> allInvoices = integrationService.getAllInvoices();

        //filter outstanding invoices related to given studentId
        List<Invoice> outstandingInvoices = allInvoices.stream()
                       .filter(invoice -> studentId.equals(invoice.getStudentId()))
                       .filter(invoice -> invoice.getStatus() == Invoice.Status.OUTSTANDING)
                       .collect(Collectors.toList());

        return outstandingInvoices;
    }
}
