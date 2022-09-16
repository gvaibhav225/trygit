package com.example.OnlineJobPortal.serviceimpl;

import com.example.OnlineJobPortal.entity.Freelancer;
import com.example.OnlineJobPortal.entity.Job;
import com.example.OnlineJobPortal.entity.JobApplication;
import com.example.OnlineJobPortal.service.IJobApplicationService;

import org.springframework.stereotype.Service;

@Service
public class IJobApplicationServiceImpl implements IJobApplicationService {

	@Override
	public JobApplication applyToJob(Job job, String coverLetter, Freelancer freelancer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JobApplication updateJobApplication(Job job, String coverLetter, Freelancer freelancer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JobApplication findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
