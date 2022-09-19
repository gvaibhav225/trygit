package com.example.OnlineJobPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.OnlineJobPortal.entity.Job;
import com.example.OnlineJobPortal.entity.JobApplication;

public interface JobApplicationRepository  extends JpaRepository<JobApplication,Integer> {

}
