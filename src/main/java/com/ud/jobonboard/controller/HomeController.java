package com.ud.jobonboard.controller;

import com.ud.jobonboard.service.CompanyService;
import com.ud.jobonboard.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private JobService jobService;

    @GetMapping("/")
    public String home(
            Model model
    ){
        model.addAttribute("companyList",companyService.getAllCompany());
        model.addAttribute("jobList",jobService.getAllJob());
        return "index";
    }

    @GetMapping("index")
    public String index(
            Model model
    ){
        model.addAttribute("companyList",companyService.getAllCompany());
        model.addAttribute("jobList",jobService.getAllJob());
        return "index";
    }

    @GetMapping("addjob")
    public String addJob(
            Model model
    ){
        model.addAttribute("companyList",companyService.getAllCompany());
        return "addjob";
    }

    @GetMapping("addcompany")
    public String addCompany(){
        return "addcompany";
    }

    @GetMapping("success")
    public String success(){
        return "success";
    }

    @GetMapping("error")
    public String error(){
        return "error";
    }
}
