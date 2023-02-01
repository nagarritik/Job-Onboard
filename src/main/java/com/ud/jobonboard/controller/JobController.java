package com.ud.jobonboard.controller;

import com.ud.jobonboard.model.Company;
import com.ud.jobonboard.model.Job;
import com.ud.jobonboard.service.CompanyService;
import com.ud.jobonboard.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class JobController {
    @Autowired
    private JobService jobService;
    @Autowired
    private CompanyService companyService;

    @PostMapping("job/post")
    public RedirectView addJob(
            @ModelAttribute Job job,
            RedirectView redirectView,
            HttpServletRequest httpServletRequest,
            HttpSession httpSession,
            @RequestParam int companyId
    ){
        Company company = companyService.getCompany(companyId);
        job.setCompany(company);
        jobService.addJob(job);
        companyService.addJobToCompany(companyId,job);
        redirectView.setUrl(httpServletRequest.getContextPath()+"/success");
        httpSession.setAttribute("success","Job Added Successfully");
        httpSession.setAttribute("url","index");
        return redirectView;
    }

    @GetMapping("job/{id}")
    public String job(
            @PathVariable int id,
            Model model
    ){
        model.addAttribute("job",jobService.getJob(id));
        return "job";
    }
}
