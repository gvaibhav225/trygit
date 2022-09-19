package com.example.OnlineJobPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.OnlineJobPortal.entity.Freelancer;
import com.example.OnlineJobPortal.entity.Recruiter;

public interface RecruiterRepository extends JpaRepository<Recruiter,Integer> {

}
