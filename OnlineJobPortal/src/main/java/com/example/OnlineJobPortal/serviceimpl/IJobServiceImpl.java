package com.example.OnlineJobPortal.serviceimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.example.OnlineJobPortal.Dto.JobDto;
import com.example.OnlineJobPortal.Exception.FreelancerAlreadyExistsException;
import com.example.OnlineJobPortal.Exception.FreelancerDoesNotExistsException;
import com.example.OnlineJobPortal.entity.Freelancer;
import com.example.OnlineJobPortal.entity.Job;
import com.example.OnlineJobPortal.entity.Recruiter;
import com.example.OnlineJobPortal.entity.Skill;
import com.example.OnlineJobPortal.repository.FreelancerRepository;
import com.example.OnlineJobPortal.repository.JobRepository;
import com.example.OnlineJobPortal.repository.RecruiterRepository;
import com.example.OnlineJobPortal.repository.SkillRepository;
import com.example.OnlineJobPortal.service.IJobService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IJobServiceImpl implements IJobService {
	
	
	@Autowired
	RecruiterRepository recruiterRepo;
	
	@Autowired
	FreelancerRepository freeRepo;

	@Autowired
	SkillRepository skillRepo;
	
	@Autowired
	JobRepository jobRepo;
	
	@Override
	public Job postjob(JobDto jobdto) throws FreelancerAlreadyExistsException {
		// TODO Auto-generated method stub
		if(jobRepo.existsById(jobdto.getId())) {
			throw new FreelancerAlreadyExistsException();
		}
		if(skillRepo.existsById(jobdto.getSkillid())&&recruiterRepo.existsById(jobdto.getRecruiterid())) {
			Job job=new Job();
			job.setActive(true);
			job.setId(jobdto.getId());
			job.setSkill(skillRepo.findById(jobdto.getSkillid()).get());
			job.setPostedBy(recruiterRepo.getById(jobdto.getRecruiterid()));
			job.setPosteddate(LocalDate.now());
			job.setDescription(jobdto.getDescription());
			job.setTitle((jobdto.getTitle()));
			
			return jobRepo.save(job);
			
		}else {
			throw new FreelancerAlreadyExistsException();
		}
	}

	@Override
	public Optional<Job> findById(int id) throws FreelancerDoesNotExistsException {
		// TODO Auto-generated method stub
		if(jobRepo.existsById(id)) {
			Optional<Job> finded=jobRepo.findById(id);
		return finded;
		}
		else {
			throw new FreelancerDoesNotExistsException();
		}
	}

	@Override
	public List<Job> findJobsBySkill(String skillname) throws FreelancerDoesNotExistsException {
		// TODO Auto-generated method stub
		if(jobRepo.findJobsBySkill(skillname).isEmpty()) {
			
			throw new FreelancerDoesNotExistsException();
		
		}else {
			return  jobRepo.findJobsBySkill(skillname);
		}
	
	}

	@Override
	public List<Job> close(int id) throws FreelancerDoesNotExistsException {
		// TODO Auto-generated method stub
		if(jobRepo.existsById(id)) {
			
			Job present=jobRepo.findById(id).get();
			
			
			present.setActive(false);
			
			jobRepo.save(present);
			return jobRepo.findAll();
		}
		else {
			throw new FreelancerDoesNotExistsException();
		}
		
	}

	@Override
	public void awardJob(int jobId, int freelancerId) {
		
			Job job = jobRepo.findById(jobId).get();
			Freelancer freelancer = freeRepo.findById(freelancerId).get();
//			job.setAwardedTo(freelancer);
			
		}

	@Override
	public List<Job> findByrecId(int id) {
		// TODO Auto-generated method stub
		return jobRepo.findbyrecid(id);
	}

	@Override
	public List<Job> findByactive() {
		// TODO Auto-generated method stub
		return jobRepo.findByactive();
	}
		
	}


