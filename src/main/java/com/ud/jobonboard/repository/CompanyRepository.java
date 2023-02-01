package com.ud.jobonboard.repository;

import com.ud.jobonboard.model.Company;
import com.ud.jobonboard.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.awt.event.ComponentAdapter;
import java.util.List;
import java.util.Objects;

@Repository
public class CompanyRepository {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional
    public void addCompany(Company company){
        hibernateTemplate.save(company);
    }

    public List<Company> getAllCompany(){
        return hibernateTemplate.loadAll(Company.class);
    }

    public Company getCompany(int id){
        return hibernateTemplate.get(Company.class,id);
    }

    @Transactional
    public void addJobToCompany(int companyId, Job job){
        getCompany(companyId).getJobList().add(job);
    }

    public boolean isCompanyAlreadyExist(Company company){
        boolean companyExist = false;

        List<Company> companyList = getAllCompany();

        for (Company item:companyList){
            if (Objects.equals(item.getName(), company.getName())){
                companyExist=true;
            }
        }

        return companyExist;
    }
}