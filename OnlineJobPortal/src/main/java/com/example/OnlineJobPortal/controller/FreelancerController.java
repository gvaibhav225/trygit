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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.OnlineJobPortal.Dto.FreelancerDto;
import com.example.OnlineJobPortal.Exception.FreelancerAlreadyExistsException;
import com.example.OnlineJobPortal.Exception.FreelancerDoesNotExistsException;
import com.example.OnlineJobPortal.Exception.ThisPassCantBeSetException;
import com.example.OnlineJobPortal.entity.Freelancer;
import com.example.OnlineJobPortal.service.IFreelancerService;

//TO TERINATE PORT : open cmd-> netstat -ano | findstr :8080-> taskkill /PID 26168 /F          (26168 is shown there)
@RestController
public class FreelancerController {
	
	@Autowired
	IFreelancerService freeServ;
	
	@PostMapping("/freesave")
	public ResponseEntity<String> save(@Valid @RequestBody FreelancerDto freelancerdto, BindingResult bindingresult) throws FreelancerAlreadyExistsException {
		if(bindingresult.hasErrors()) {
			return new ResponseEntity<String>("some error occured", HttpStatus.BAD_REQUEST);
		}
		Freelancer saveduser= freeServ.save(freelancerdto);
		return new ResponseEntity<String>("Saved Successfully", HttpStatus.CREATED);
	}
	
	
	@GetMapping("/freefind/{id}")
	public ResponseEntity<Optional<Freelancer>> findById(@PathVariable int id) throws FreelancerDoesNotExistsException{
		Optional<Freelancer> finded=freeServ.findById(id);
		return new ResponseEntity<Optional<Freelancer>>(finded,HttpStatus.OK);
	}
	
	
	@PutMapping("/freeupdate/{id}")
	public ResponseEntity<String> update(@RequestBody FreelancerDto freelancerdto,@PathVariable int id) throws FreelancerDoesNotExistsException, ThisPassCantBeSetException {

		Freelancer updated=freeServ.update(freelancerdto, id);
		return new ResponseEntity<String>("Updated", HttpStatus.CREATED);
	}

}
