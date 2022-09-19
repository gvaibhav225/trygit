package com.example.OnlineJobPortal.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
import com.example.OnlineJobPortal.Exception.ThisPassCantBeSetException;
import com.example.OnlineJobPortal.entity.Freelancer;
import com.example.OnlineJobPortal.entity.Job;
import com.example.OnlineJobPortal.service.IFreelancerService;
import com.example.OnlineJobPortal.service.IJobService;

@RestController
public class JobController {
	
	@Autowired
	IJobService jobServ;
	
	@PostMapping("/jobsave")
	public ResponseEntity<String> save(@Valid @RequestBody JobDto jobdto, BindingResult bindingresult) throws FreelancerAlreadyExistsException {
		if(bindingresult.hasErrors()) {
			return new ResponseEntity<String>("some error occured", HttpStatus.BAD_REQUEST);
		}
		Job savedjob= jobServ.postjob(jobdto);
		return new ResponseEntity<String>("Saved Successfully", HttpStatus.CREATED);
	}
	
	
	@GetMapping("/jobfind/{id}")
	public ResponseEntity<Optional<Job>> findById(@PathVariable int id) throws FreelancerDoesNotExistsException{
		Optional<Job> finded=jobServ.findById(id);
		return new ResponseEntity<Optional<Job>>(finded,HttpStatus.OK);
	}
	
	
//	@PutMapping("/freeupdate/{id}")
//	public ResponseEntity<String> update(@RequestBody FreelancerDto freelancerdto,@PathVariable int id) throws FreelancerDoesNotExistsException, ThisPassCantBeSetException {
//
//		Freelancer updated=freeServ.update(freelancerdto, id);
//		return new ResponseEntity<String>("Updated", HttpStatus.CREATED);
//	}
	
	@GetMapping("/close/{id}")
	public ResponseEntity<String>  close(@PathVariable int id) throws FreelancerDoesNotExistsException {
		jobServ.close(id);
		return new ResponseEntity<String> ("job closed",HttpStatus.OK);
	}

}
