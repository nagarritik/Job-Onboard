package com.ud.jobonboard.service;

import com.ud.jobonboard.model.Company;
import com.ud.jobonboard.model.Job;
import com.ud.jobonboard.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public void addCompany(Company company){
        companyRepository.addCompany(company);
    }

    public List<Company> getAllCompany(){
        return companyRepository.getAllCompany();
    }

    public Company getCompany(int id){
        return companyRepository.getCompany(id);
    }

    public void addJobToCompany(int companyId, Job job){
        companyRepository.addJobToCompany(companyId,job);
    }

    public boolean isCompanyAlreadyExist(Company company){
        return companyRepository.isCompanyAlreadyExist(company);
    }
}
