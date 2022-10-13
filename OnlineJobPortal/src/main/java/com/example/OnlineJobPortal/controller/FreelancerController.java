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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.OnlineJobPortal.Dto.FreelancerDto;
import com.example.OnlineJobPortal.Exception.FreelancerAlreadyExistsException;
import com.example.OnlineJobPortal.Exception.FreelancerDoesNotExistsException;
import com.example.OnlineJobPortal.Exception.InvalidAdminException;
import com.example.OnlineJobPortal.Exception.InvalidPasswordException;
import com.example.OnlineJobPortal.entity.Admin;
import com.example.OnlineJobPortal.entity.Freelancer;
import com.example.OnlineJobPortal.service.IFreelancerService;

//TO TERINATE PORT : open cmd-> netstat -ano | findstr :8080-> taskkill /PID 26168 /F          (26168 is shown there)
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FreelancerController {
	
	@Autowired
	IFreelancerService freeServ;
	
	@PostMapping("/freesave")
	public ResponseEntity<Freelancer> save(@Valid @RequestBody FreelancerDto freelancerdto, BindingResult bindingresult) throws FreelancerAlreadyExistsException {
		if(bindingresult.hasErrors()) {
			return new ResponseEntity<Freelancer>( HttpStatus.BAD_REQUEST);
		}
		Freelancer saveduser= freeServ.save(freelancerdto);
		return new ResponseEntity<Freelancer>(saveduser, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/freefind/{id}")
	public ResponseEntity<Optional<Freelancer>> findById(@PathVariable int id) throws FreelancerDoesNotExistsException{
		Optional<Freelancer> finded=freeServ.findById(id);
		return new ResponseEntity<Optional<Freelancer>>(finded,HttpStatus.OK);
	}
	
	
	@PutMapping("/freeupdate/{id}")
	public ResponseEntity<String> update(@RequestBody FreelancerDto freelancerdto,@PathVariable int id) throws FreelancerDoesNotExistsException, InvalidPasswordException {

		Freelancer updated=freeServ.update(freelancerdto, id);
		return new ResponseEntity<String>("Updated", HttpStatus.CREATED);
	}
	@GetMapping("/freeFindAll")
	public ResponseEntity<List<Freelancer>> findAll() throws InvalidAdminException{
		List<Freelancer> adminFound =freeServ.findAll();
		return new ResponseEntity<List<Freelancer>>(adminFound,HttpStatus.OK);
	}

	
	@DeleteMapping("/deletefree/{id}")
	public ResponseEntity<List<Freelancer>> deletebyid(@PathVariable int id){
		List<Freelancer> updated=freeServ.deletebyid(id);
	return new  ResponseEntity<List<Freelancer>>(updated,HttpStatus.OK);
		
	}
	
	
	
}
