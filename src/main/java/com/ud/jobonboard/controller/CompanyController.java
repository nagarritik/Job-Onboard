package com.ud.jobonboard.controller;

import com.ud.jobonboard.model.Company;
import com.ud.jobonboard.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @PostMapping("company/post")
    public RedirectView addCompany(
            @ModelAttribute Company company,
            RedirectView redirectView,
            HttpServletRequest httpServletRequest,
            HttpSession httpSession
            ){
        if (companyService.isCompanyAlreadyExist(company)){
            redirectView.setUrl(httpServletRequest.getContextPath()+"/error");
            httpSession.setAttribute("error","Company Already Exists");
            httpSession.setAttribute("url","index");
            return redirectView;
        }else {
            companyService.addCompany(company);
            redirectView.setUrl(httpServletRequest.getContextPath()+"/success");
            httpSession.setAttribute("success","Company Added Successfully");
            httpSession.setAttribute("url","index");
            return redirectView;
        }
    }

    @GetMapping("company/{id}")
    public String company(
            @PathVariable int id,
            Model model
    ){
        Company company = companyService.getCompany(id);
        model.addAttribute("company",company);
        return "company";
    }
}
