package com.example.OnlineJobPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.OnlineJobPortal.entity.Job;

public interface JobRepository extends JpaRepository<Job,Integer> {

}
