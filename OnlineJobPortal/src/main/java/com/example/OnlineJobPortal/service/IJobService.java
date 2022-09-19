package com.example.OnlineJobPortal.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.example.OnlineJobPortal.Dto.JobDto;
import com.example.OnlineJobPortal.Exception.FreelancerAlreadyExistsException;
import com.example.OnlineJobPortal.Exception.FreelancerDoesNotExistsException;
import com.example.OnlineJobPortal.entity.Job;
import com.example.OnlineJobPortal.entity.Recruiter;
import com.example.OnlineJobPortal.entity.Skill;

public interface IJobService {
	public Job postjob(JobDto jobdto) throws FreelancerAlreadyExistsException;
	public Optional<Job> findById(int id) throws FreelancerDoesNotExistsException;
	public List<Job> findJobsBySkill(Skill skill);
	public void close(int id) throws FreelancerDoesNotExistsException;

}
