package com.example.OnlineJobPortal.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
import com.example.OnlineJobPortal.Exception.ThisPassCantBeSetException;
import com.example.OnlineJobPortal.entity.Freelancer;
import com.example.OnlineJobPortal.entity.Skill;

import com.example.OnlineJobPortal.service.IFreelancerService;
import com.example.OnlineJobPortal.service.ISkillService;

@RestController
public class SkillController {
	
	@Autowired
	ISkillService skillServ;
	
	@PostMapping("/skillsave")
	public ResponseEntity<String> save(@Valid @RequestBody SkillDto skilldto, BindingResult bindingresult) throws FreelancerAlreadyExistsException {
		if(bindingresult.hasErrors()) {
			return new ResponseEntity<String>("some error occured", HttpStatus.BAD_REQUEST);
		}
		Skill saveduser= skillServ.save(skilldto);
		return new ResponseEntity<String>("Saved Successfully", HttpStatus.CREATED);
	}
	
	
	
	@PutMapping("/skillupdate/{id}")
	public ResponseEntity<String> update(@RequestBody SkillDto skilldto,@PathVariable int id) throws FreelancerDoesNotExistsException{

		Skill updated=skillServ.update(skilldto, id);
		return new ResponseEntity<String>("Updated", HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> remove(@PathVariable int id) throws FreelancerDoesNotExistsException{
		skillServ.remove(id);
		return new ResponseEntity<String>("Deleated Successfully", HttpStatus.GONE);
	}
	
}

