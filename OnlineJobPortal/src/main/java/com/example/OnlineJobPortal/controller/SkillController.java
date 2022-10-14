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
import com.example.OnlineJobPortal.Dto.SkillDto;
import com.example.OnlineJobPortal.Exception.FreelancerAlreadyExistsException;
import com.example.OnlineJobPortal.Exception.FreelancerDoesNotExistsException;
import com.example.OnlineJobPortal.Exception.InvalidAdminException;
import com.example.OnlineJobPortal.Exception.InvalidPasswordException;
import com.example.OnlineJobPortal.entity.Admin;
import com.example.OnlineJobPortal.entity.Freelancer;
import com.example.OnlineJobPortal.entity.Skill;

import com.example.OnlineJobPortal.service.IFreelancerService;
import com.example.OnlineJobPortal.service.ISkillService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SkillController {
	
	@Autowired
	ISkillService skillServ;
	
	@PostMapping("/skillsave")
	public ResponseEntity<Skill> save(@Valid @RequestBody SkillDto skilldto, BindingResult bindingresult) throws FreelancerAlreadyExistsException {
		if(bindingresult.hasErrors()) {
			return new ResponseEntity<Skill>( HttpStatus.BAD_REQUEST);
		}
		Skill saveduser= skillServ.save(skilldto);
		return new ResponseEntity<Skill>(saveduser, HttpStatus.CREATED);
	}
	
	
	
	@PutMapping("/skillupdate/{id}")
	public ResponseEntity<String> update(@RequestBody SkillDto skilldto,@PathVariable int id) throws FreelancerDoesNotExistsException{

		Skill updated=skillServ.update(skilldto, id);
		return new ResponseEntity<String>("Updated", HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<List<Skill>> remove(@PathVariable int id) throws FreelancerDoesNotExistsException{
		List<Skill> li=skillServ.remove(id);
		return new ResponseEntity<List<Skill>>(li, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/skillFindAll")
	public ResponseEntity<List<Skill>> findAll() throws InvalidAdminException{
		List<Skill> adminFound =skillServ.findAll();
		return new ResponseEntity<List<Skill>>(adminFound,HttpStatus.OK);
	}
	
	
}

