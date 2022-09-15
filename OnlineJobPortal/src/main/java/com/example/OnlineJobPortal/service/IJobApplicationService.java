package com.example.OnlineJobPortal.service;

import com.example.OnlineJobPortal.entity.Freelancer;
import com.example.OnlineJobPortal.entity.Job;
import com.example.OnlineJobPortal.entity.JobApplication;

public interface IJobApplicationService {
	public JobApplication applyToJob(Job job,String coverLetter,Freelancer freelancer);
	public JobApplication updateJobApplication(Job job,String coverLetter,Freelancer freelancer);
	public JobApplication findById(long id);
}
