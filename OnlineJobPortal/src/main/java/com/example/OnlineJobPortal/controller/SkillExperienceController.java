package com.example.OnlineJobPortal.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.OnlineJobPortal.Dto.FreelancerDto;
import com.example.OnlineJobPortal.Dto.SkillExperienceDto;
import com.example.OnlineJobPortal.Exception.FreelancerAlreadyExistsException;
import com.example.OnlineJobPortal.Exception.FreelancerDoesNotExistsException;
import com.example.OnlineJobPortal.Exception.ThisPassCantBeSetException;
import com.example.OnlineJobPortal.entity.Freelancer;
import com.example.OnlineJobPortal.entity.SkillExperience;
import com.example.OnlineJobPortal.service.ISkillExperienceService;

@RestController
public class SkillExperienceController {

	@Autowired
	public ISkillExperienceService skillexServ;
	
	
	@PostMapping("/skillexsave")
	public ResponseEntity<String> addSkill(@Valid @RequestBody SkillExperienceDto skillexdto, BindingResult bindingresult) throws FreelancerAlreadyExistsException {
		if(bindingresult.hasErrors()) {
			return new ResponseEntity<String>("some error occured", HttpStatus.BAD_REQUEST);
		}
		SkillExperience saveduser= skillexServ.addSkill(skillexdto);
		return new ResponseEntity<String>("Saved Successfully", HttpStatus.CREATED);
	}
	
	
	@PutMapping("/skillexupdate/{id}")
	public ResponseEntity<String> update(@PathVariable double years, @PathVariable int id) throws FreelancerDoesNotExistsException, ThisPassCantBeSetException {

		SkillExperience saveduser= skillexServ.updateSkillYears(years, id);
		return new ResponseEntity<String>("Updated", HttpStatus.CREATED);
	}

}
