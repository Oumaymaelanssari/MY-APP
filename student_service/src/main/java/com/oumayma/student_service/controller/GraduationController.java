package com.oumayma.student_service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.oumayma.student_service.model.Account;
import com.oumayma.student_service.config.CustomUserDetails;
import com.oumayma.student_service.service.IntegrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

@Controller
public class GraduationController {

    @Autowired
    private IntegrationService integrationService;

    @RequestMapping("/graduation")
    public ModelAndView graduation(@AuthenticationPrincipal CustomUserDetails student) {

        Account account = integrationService.getStudentFinanceAccount(student.getStudentId());
        boolean isEligableToGraduate = !account.isHasOutstandingBalance();

        ModelAndView modelAndView = new ModelAndView("check-graduation");
        modelAndView.addObject("isEligableToGraduate", isEligableToGraduate);
        if (isEligableToGraduate) {
            modelAndView.addObject("graduationStatusMessage", "ELIGABLE TO GRADUATE");
        } else {
            modelAndView.addObject("graduationStatusMessage", "NOT ELIGABLE TO GRADUATE");
        }
        return modelAndView;

    }

}
