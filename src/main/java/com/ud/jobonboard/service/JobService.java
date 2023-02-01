package com.ud.jobonboard.service;

import com.ud.jobonboard.model.Applicant;
import com.ud.jobonboard.model.Job;
import com.ud.jobonboard.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    public void addJob(Job job){
        jobRepository.addJob(job);
    }

    public List<Job> getAllJob(){
        return jobRepository.getAllJob();
    }

    public Job getJob(int id){
        return jobRepository.getJob(id);
    }

    public void addApplicantToJob(int jobId, Applicant applicant){
        jobRepository.addApplicantToJob(jobId,applicant);
    }

    public boolean applicantAlreadyApplied(Applicant applicant,int jobId){
        return jobRepository.applicantAlreadyApplied(applicant,jobId);
    }
}
