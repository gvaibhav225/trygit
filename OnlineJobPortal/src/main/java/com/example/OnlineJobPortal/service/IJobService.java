package com.example.OnlineJobPortal.service;

import java.util.List;

import com.example.OnlineJobPortal.entity.Job;
import com.example.OnlineJobPortal.entity.Recruiter;
import com.example.OnlineJobPortal.entity.Skill;

public interface IJobService {
	public Job postjob(Skill skill, Recruiter recruiter);
	public Job findById(long id);
	public List<Job> findJobsBySkill(Skill skill);
	public void close(Job job);
}
