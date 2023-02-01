package com.ud.jobonboard.service;

import com.ud.jobonboard.model.Applicant;
import com.ud.jobonboard.repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicantService {
    @Autowired
    private ApplicantRepository applicantRepository;

    public void addApplicant(Applicant applicant){
        applicantRepository.addApplicant(applicant);
    }
}
