package com.example.OnlineJobPortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.OnlineJobPortal.entity.Job;
import com.example.OnlineJobPortal.entity.JobApplication;
@Repository
public interface JobApplicationRepository  extends JpaRepository<JobApplication,Integer> {

	
	@Query("Select j from JobApplication j where j.freelance.id=:id")
	public List<JobApplication> findbyfreeid(@Param("id") int id);
}
