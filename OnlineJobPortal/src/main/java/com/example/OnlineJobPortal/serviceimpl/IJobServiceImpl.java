package com.example.OnlineJobPortal.serviceimpl;

import java.util.List;

import com.example.OnlineJobPortal.entity.Job;
import com.example.OnlineJobPortal.entity.Recruiter;
import com.example.OnlineJobPortal.entity.Skill;
import com.example.OnlineJobPortal.service.IJobService;

import org.springframework.stereotype.Service;

@Service
public class IJobServiceImpl implements IJobService {

	@Override
	public Job postjob(Skill skill, Recruiter recruiter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Job findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Job> findJobsBySkill(Skill skill) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void close(Job job) {
		// TODO Auto-generated method stub
		
	}

}
