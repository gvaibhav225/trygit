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
import com.example.OnlineJobPortal.Dto.JobApplicationDto;
import com.example.OnlineJobPortal.Exception.FreelancerAlreadyExistsException;
import com.example.OnlineJobPortal.Exception.FreelancerDoesNotExistsException;
import com.example.OnlineJobPortal.Exception.InvalidPasswordException;
import com.example.OnlineJobPortal.entity.Freelancer;
import com.example.OnlineJobPortal.entity.JobApplication;
import com.example.OnlineJobPortal.service.IFreelancerService;
import com.example.OnlineJobPortal.service.IJobApplicationService;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class JobApplicationController  {
	
	@Autowired
	IJobApplicationService jaServ;
	
	@PostMapping("/jobappsave")
	public ResponseEntity<JobApplication> applyToJob(@Valid @RequestBody JobApplicationDto jobappdto , BindingResult bindingresult) throws FreelancerAlreadyExistsException {
		if(bindingresult.hasErrors()) {
			return new ResponseEntity<JobApplication>( HttpStatus.BAD_REQUEST);
		}
		JobApplication applied= jaServ.applyToJob(jobappdto);
		return new ResponseEntity<JobApplication>(applied, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/jobappfind/{id}")
	public ResponseEntity<Optional<JobApplication>> findById(@PathVariable int id) throws FreelancerDoesNotExistsException{
		Optional<JobApplication> finded=jaServ.findById(id);
		return new ResponseEntity<Optional<JobApplication>>(finded,HttpStatus.OK);
	}
	
	
	@PutMapping("/jobappupdate/{id}")
	public ResponseEntity<String> updateJobApplication(@RequestBody JobApplicationDto jobappdto,@PathVariable int id) throws FreelancerDoesNotExistsException, InvalidPasswordException {

		JobApplication updated=jaServ.updateJobApplication(jobappdto, id);
		return new ResponseEntity<String>("Updated", HttpStatus.CREATED);
	}
	
	
	@GetMapping("/jobappfindbyfree/{id}")
	public ResponseEntity<List<JobApplication>> findByfreeId(@PathVariable int id) throws FreelancerDoesNotExistsException{
		List<JobApplication> finded=jaServ.findByfreeId(id);
		return new ResponseEntity<List<JobApplication>>(finded,HttpStatus.OK);
	}
	
	
	
	

}
