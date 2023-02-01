package com.ud.jobonboard.repository;

import com.ud.jobonboard.model.Applicant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ApplicantRepository {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional
    public void addApplicant(Applicant applicant){
        hibernateTemplate.save(applicant);
    }
}
