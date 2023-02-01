package com.ud.jobonboard.model;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String website;
    private String location;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Job> jobList;

    public Company(int id, String name, String website, String location) {
        this.id = id;
        this.name = name;
        this.website = website;
        this.location = location;
        this.jobList = new ArrayList<>();
    }

    public Company(String name, String website, String location) {
        this.name = name;
        this.website = website;
        this.location = location;
        this.jobList = new ArrayList<>();
    }

    public Company() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Job> getJobList() {
        return jobList;
    }

    public void setJobList(List<Job> jobList) {
        this.jobList = jobList;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", website='" + website + '\'' +
                ", location='" + location + '\'' +
                ", jobList=" + jobList +
                '}';
    }
}
