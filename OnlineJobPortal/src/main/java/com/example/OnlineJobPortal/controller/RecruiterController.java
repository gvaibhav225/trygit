package com.example.OnlineJobPortal.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.OnlineJobPortal.Dto.FreelancerDto;
import com.example.OnlineJobPortal.Dto.RecruiterDto;
import com.example.OnlineJobPortal.Exception.FreelancerAlreadyExistsException;
import com.example.OnlineJobPortal.Exception.FreelancerDoesNotExistsException;
import com.example.OnlineJobPortal.Exception.InvalidAdminException;
import com.example.OnlineJobPortal.Exception.InvalidPasswordException;
import com.example.OnlineJobPortal.entity.Freelancer;
import com.example.OnlineJobPortal.entity.Recruiter;
import com.example.OnlineJobPortal.service.IFreelancerService;
import com.example.OnlineJobPortal.service.IRecruiterService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RecruiterController {
	
	@Autowired
	IRecruiterService recruiterServ;
	
	@PostMapping("/recruitersave")
	public ResponseEntity<	Recruiter> save(@Valid @RequestBody RecruiterDto recruiterdto, BindingResult bindingresult) throws FreelancerAlreadyExistsException {
		if(bindingresult.hasErrors()) {
			return new ResponseEntity<Recruiter>( HttpStatus.BAD_REQUEST);
		}
		Recruiter saveduser= recruiterServ.save(recruiterdto);
		return new ResponseEntity<Recruiter>(saveduser, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/recruiterfind/{id}")
	public ResponseEntity<Optional<Recruiter>> findById(@PathVariable int id) throws FreelancerDoesNotExistsException{
		Optional<Recruiter> finded=recruiterServ.findById(id);
		return new ResponseEntity<Optional<Recruiter>>(finded,HttpStatus.OK);
	}
	
	
	@PutMapping("/recruiterupdate/{id}")
	public ResponseEntity<String> update(@RequestBody RecruiterDto recruiterdto,@PathVariable int id) throws FreelancerDoesNotExistsException, InvalidPasswordException {

		Recruiter updated=recruiterServ.update(recruiterdto, id);
		return new ResponseEntity<String>("Updated", HttpStatus.CREATED);
	}
	
	@GetMapping("/recruiterFindAll")
	public ResponseEntity<List<Recruiter>> findAll() throws InvalidAdminException{
		List<Recruiter> adminFound =recruiterServ.findAll();
		return new ResponseEntity<List<Recruiter>>(adminFound,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/deleterecruiter/{id}")
	public ResponseEntity<List<Recruiter>> deletebyid(@PathVariable int id){
		List<Recruiter> updated=recruiterServ.deletebyid(id);
	return new  ResponseEntity<List<Recruiter>>(updated,HttpStatus.OK);
		
	}
	

}
