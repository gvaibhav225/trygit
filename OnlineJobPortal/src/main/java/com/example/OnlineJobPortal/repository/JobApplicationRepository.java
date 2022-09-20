package com.example.OnlineJobPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.OnlineJobPortal.entity.Job;
import com.example.OnlineJobPortal.entity.JobApplication;
@Repository
public interface JobApplicationRepository  extends JpaRepository<JobApplication,Integer> {

}
