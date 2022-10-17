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
import com.example.OnlineJobPortal.Dto.SkillExperienceDto;
import com.example.OnlineJobPortal.Exception.FreelancerAlreadyExistsException;
import com.example.OnlineJobPortal.Exception.FreelancerDoesNotExistsException;
import com.example.OnlineJobPortal.Exception.InvalidPasswordException;
import com.example.OnlineJobPortal.entity.Freelancer;
import com.example.OnlineJobPortal.entity.SkillExperience;
import com.example.OnlineJobPortal.service.ISkillExperienceService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SkillExperienceController {

	@Autowired
	public ISkillExperienceService skillexServ;
	
	
	@PostMapping("/skillexsave")
	public ResponseEntity<SkillExperience> addSkill(@Valid @RequestBody SkillExperienceDto skillexdto, BindingResult bindingresult) throws FreelancerAlreadyExistsException {
		if(bindingresult.hasErrors()) {
			return new ResponseEntity<SkillExperience>( HttpStatus.BAD_REQUEST);
		}
		SkillExperience saveduser= skillexServ.addSkill(skillexdto);
		return new ResponseEntity<SkillExperience>(saveduser, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/skillexupdate/{id}")
	public ResponseEntity<SkillExperience> update(@RequestBody SkillExperienceDto skillexdto, @PathVariable int id) throws FreelancerDoesNotExistsException, InvalidPasswordException {

		SkillExperience saveduser= skillexServ.updateSkillYears(skillexdto, id);
		return new ResponseEntity<SkillExperience>(saveduser, HttpStatus.CREATED);
	}
	
	@GetMapping("/skillexfindall/{id}")
	public ResponseEntity<List<SkillExperience>> findById(@PathVariable int id) throws FreelancerDoesNotExistsException{
		List<SkillExperience> finded=skillexServ.findallByfreeId(id);
		return new ResponseEntity<List<SkillExperience>>(finded,HttpStatus.OK);
	}
	

}
