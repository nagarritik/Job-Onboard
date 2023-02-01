package com.ud.jobonboard.repository;

import com.ud.jobonboard.model.Applicant;
import com.ud.jobonboard.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Repository
public class JobRepository {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional
    public void addJob(Job job){
        hibernateTemplate.save(job);
    }

    public List<Job> getAllJob(){
        return hibernateTemplate.loadAll(Job.class);
    }

    public Job getJob(int id){
        return hibernateTemplate.get(Job.class,id);
    }

    @Transactional
    public void addApplicantToJob(int jobId, Applicant applicant){
        getJob(jobId).getApplicantList().add(applicant);
    }

    public boolean applicantAlreadyApplied(Applicant applicant,int jobId){
        boolean isApplicantPresent = false;

        Job job = getJob(jobId);

        List<Applicant> applicantList = job.getApplicantList();

        for (Applicant item:applicantList){
            if (Objects.equals(item.getEmail(), applicant.getEmail())){
                isApplicantPresent=true;
            }
        }

        return isApplicantPresent;
    }
}
