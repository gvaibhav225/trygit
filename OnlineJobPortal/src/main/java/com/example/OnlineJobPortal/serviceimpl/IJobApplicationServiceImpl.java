package com.example.OnlineJobPortal.serviceimpl;

import com.example.OnlineJobPortal.Dto.JobApplicationDto;
import com.example.OnlineJobPortal.Exception.FreelancerAlreadyExistsException;
import com.example.OnlineJobPortal.Exception.FreelancerDoesNotExistsException;
import com.example.OnlineJobPortal.entity.Freelancer;
import com.example.OnlineJobPortal.entity.Job;
import com.example.OnlineJobPortal.entity.JobApplication;
import com.example.OnlineJobPortal.repository.FreelancerRepository;
import com.example.OnlineJobPortal.repository.JobApplicationRepository;
import com.example.OnlineJobPortal.repository.JobRepository;
import com.example.OnlineJobPortal.repository.RecruiterRepository;
import com.example.OnlineJobPortal.repository.SkillRepository;
import com.example.OnlineJobPortal.service.IJobApplicationService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IJobApplicationServiceImpl implements IJobApplicationService {


	@Autowired
	RecruiterRepository recruiterRepo;
	
	@Autowired
	FreelancerRepository freeRepo;

	@Autowired
	SkillRepository skillRepo;
	
	@Autowired
	JobRepository jobRepo;
	
	@Autowired
	JobApplicationRepository jaRepo;
	

	@Override
	public JobApplication applyToJob(JobApplicationDto jobappdto) throws FreelancerAlreadyExistsException {
		// TODO Auto-generated method stub
		if(jaRepo.existsById(jobappdto.getJobappdtoid())) {
			throw new FreelancerAlreadyExistsException();
		}
		
		if(freeRepo.existsById(jobappdto.getFreelancerid())&&jobRepo.existsById(jobappdto.getJobid())) {
			
			JobApplication job=new JobApplication();
			job.setAppliedDate(LocalDateTime.now());
			job.setCoverLetter(jobappdto.getCoverLetter());
			job.setFreelance(freeRepo.getById(jobappdto.getFreelancerid()));
			job.setId(jobappdto.getJobappdtoid());
			job.setJob(jobRepo.findById(jobappdto.getJobid()).get());
			
			return jaRepo.save(job);
		}
		else {
			throw new FreelancerAlreadyExistsException();
		}


	}

	@Override
	public JobApplication updateJobApplication(JobApplicationDto jobappdto, int id) throws FreelancerDoesNotExistsException {
		// TODO Auto-generated method stub
		if(jaRepo.existsById(id)) {
			JobApplication jobapp=jaRepo.getById(id);
			if(Objects.nonNull(jobappdto.getCoverLetter())&&!"".equalsIgnoreCase(jobappdto.getCoverLetter())) {
				jobapp.setCoverLetter(null);
			}
			return jaRepo.save(jobapp);
		}else {
			throw new FreelancerDoesNotExistsException();
		}
		
		
		
	}

	@Override
	public Optional<JobApplication> findById(int id) throws FreelancerDoesNotExistsException {
		// TODO Auto-generated method stub
		if(jaRepo.existsById(id)) {
			Optional<JobApplication> jobapp=jaRepo.findById(id);
			return jobapp;
			
		}else {
			throw new FreelancerDoesNotExistsException();
		}
	}

	@Override
	public List<JobApplication> findByfreeId(int id) {
		// TODO Auto-generated method stub
		return jaRepo.findbyfreeid(id);
	}

}
