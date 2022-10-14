package com.example.OnlineJobPortal.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.OnlineJobPortal.Dto.FreelancerDto;
import com.example.OnlineJobPortal.Dto.JobDto;
import com.example.OnlineJobPortal.Exception.FreelancerAlreadyExistsException;
import com.example.OnlineJobPortal.Exception.FreelancerDoesNotExistsException;
import com.example.OnlineJobPortal.Exception.InvalidPasswordException;
import com.example.OnlineJobPortal.entity.Freelancer;
import com.example.OnlineJobPortal.entity.Job;
import com.example.OnlineJobPortal.service.IFreelancerService;
import com.example.OnlineJobPortal.service.IJobService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class JobController {
	
	@Autowired
	IJobService jobServ;
	
	@PostMapping("/jobsave")
	public ResponseEntity<Job> save(@Valid @RequestBody JobDto jobdto, BindingResult bindingresult) throws FreelancerAlreadyExistsException {
		if(bindingresult.hasErrors()) {
			return new ResponseEntity<Job>( HttpStatus.BAD_REQUEST);
		}
		Job savedjob= jobServ.postjob(jobdto);
		return new ResponseEntity<Job>(savedjob, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/jobfind/{id}")
	public ResponseEntity<Optional<Job>> findById(@PathVariable int id) throws FreelancerDoesNotExistsException{
		Optional<Job> finded=jobServ.findById(id);
		return new ResponseEntity<Optional<Job>>(finded,HttpStatus.OK);
	}
	
	
	@GetMapping("/findbyskill/{name}")
	public ResponseEntity<List<Job>> findJobsBySkill(@PathVariable String name) throws FreelancerDoesNotExistsException{

		List<Job> job=jobServ.findJobsBySkill(name);
		return new ResponseEntity<List<Job>>(job, HttpStatus.OK);
	}
	
	@GetMapping("/close/{id}")
	public ResponseEntity<List<Job>>  close(@PathVariable int id) throws FreelancerDoesNotExistsException {
		List<Job> lii=jobServ.close(id);
		return new ResponseEntity<List<Job>> (lii,HttpStatus.OK);
	}
	
	@PutMapping("/awardJob/{jobId}/{freelancerId}")
	public ResponseEntity<String> awardJob(@PathVariable int jobId, @PathVariable int freelancerId) {
		jobServ.awardJob(jobId, freelancerId);
		return new ResponseEntity<String>("Job Awarded Successfully", HttpStatus.OK);
	}
	
	@GetMapping("/jobfindbyrecruiter/{id}")
	public ResponseEntity<List<Job>> findByrecId(@PathVariable int id) throws FreelancerDoesNotExistsException{
		List<Job> finded=jobServ.findByrecId(id);
		return new ResponseEntity<List<Job>>(finded,HttpStatus.OK);
	}
	
	@GetMapping("/jobfindbyactive")
	public ResponseEntity<List<Job>> findByactive() throws FreelancerDoesNotExistsException{
		List<Job> finded=jobServ.findByactive();
		return new ResponseEntity<List<Job>>(finded,HttpStatus.OK);
	}
	
}
