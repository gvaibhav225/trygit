package com.example.OnlineJobPortal.service;

import java.util.List;
import java.util.Optional;

import com.example.OnlineJobPortal.Dto.JobApplicationDto;
import com.example.OnlineJobPortal.Exception.FreelancerAlreadyExistsException;
import com.example.OnlineJobPortal.Exception.FreelancerDoesNotExistsException;
import com.example.OnlineJobPortal.entity.Freelancer;
import com.example.OnlineJobPortal.entity.Job;
import com.example.OnlineJobPortal.entity.JobApplication;

public interface IJobApplicationService {
	public JobApplication applyToJob(JobApplicationDto jobappdto) throws FreelancerAlreadyExistsException;
	public JobApplication updateJobApplication(JobApplicationDto jobappdto, int id) throws FreelancerDoesNotExistsException;
	public Optional<JobApplication> findById(int id) throws FreelancerDoesNotExistsException;
	public List<JobApplication> findByfreeId(int id);
	
}
