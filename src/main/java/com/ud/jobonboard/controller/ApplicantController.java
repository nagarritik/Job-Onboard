package com.ud.jobonboard.controller;

import com.ud.jobonboard.model.Applicant;
import com.ud.jobonboard.service.ApplicantService;
import com.ud.jobonboard.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ApplicantController {
    @Autowired
    private JobService jobService;
    @Autowired
    private ApplicantService applicantService;

    @PostMapping("applicant/post")
    public RedirectView addApplicant(
            @ModelAttribute Applicant applicant,
            @RequestParam int jobId,
            RedirectView redirectView,
            HttpServletRequest httpServletRequest,
            HttpSession httpSession
            ){
        if (jobService.applicantAlreadyApplied(applicant,jobId)){
            redirectView.setUrl(httpServletRequest.getContextPath()+"/error");
            httpSession.setAttribute("error","You Have Already Applied For This Job And Your Application In Under Review");
            httpSession.setAttribute("url","index");
            return redirectView;
        }else {
            applicantService.addApplicant(applicant);
            jobService.addApplicantToJob(jobId,applicant);
            redirectView.setUrl(httpServletRequest.getContextPath()+"/success");
            httpSession.setAttribute("success","Successfully Applied For Job, We Will Surly Contact You If Your Profile Got Selected For This Job");
            httpSession.setAttribute("url","index");
            return redirectView;
        }
    }
}
