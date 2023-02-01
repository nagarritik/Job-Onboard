package com.ud.jobonboard.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @Column(length = 5000)
    private String description;
    @Column(name = "qualification_requirement",length = 5000)
    private String qualificationRequirement;
    @Column(name = "key_responsibilities",length = 5000)
    private String keyResponsibilities;
    @Column(name = "required_skills",length = 5000)
    private String requiredSkills;
    @Column(name = "required_experience")
    private String requiredExperience;
    private String location;
    @OneToOne
    private Company company;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Applicant> applicantList;

    public Job() {
        super();
    }

    public Job(int id, String title, String description, String qualificationRequirement, String keyResponsibilities, String requiredSkills, String requiredExperience, String location, Company company, List<Applicant> applicantList) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.qualificationRequirement = qualificationRequirement;
        this.keyResponsibilities = keyResponsibilities;
        this.requiredSkills = requiredSkills;
        this.requiredExperience = requiredExperience;
        this.location = location;
        this.company = company;
        this.applicantList = applicantList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQualificationRequirement() {
        return qualificationRequirement;
    }

    public void setQualificationRequirement(String qualificationRequirement) {
        this.qualificationRequirement = qualificationRequirement;
    }

    public String getKeyResponsibilities() {
        return keyResponsibilities;
    }

    public void setKeyResponsibilities(String keyResponsibilities) {
        this.keyResponsibilities = keyResponsibilities;
    }

    public String getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(String requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    public String getRequiredExperience() {
        return requiredExperience;
    }

    public void setRequiredExperience(String requiredExperience) {
        this.requiredExperience = requiredExperience;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Applicant> getApplicantList() {
        return applicantList;
    }

    public void setApplicantList(List<Applicant> applicantList) {
        this.applicantList = applicantList;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", qualificationRequirement='" + qualificationRequirement + '\'' +
                ", keyResponsibilities='" + keyResponsibilities + '\'' +
                ", requiredSkills='" + requiredSkills + '\'' +
                ", requiredExperience='" + requiredExperience + '\'' +
                ", location='" + location + '\'' +
                ", company=" + company +
                ", applicantList=" + applicantList +
                '}';
    }
}
