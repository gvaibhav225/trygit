package com.example.OnlineJobPortal.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.OnlineJobPortal.Dto.BookmarkedJobDTO;
import com.example.OnlineJobPortal.Exception.FreelancerAlreadyExistsException;
import com.example.OnlineJobPortal.Exception.InvalidBookmarkedFreelancerException;
import com.example.OnlineJobPortal.Exception.InvalidBookmarkedJobException;
import com.example.OnlineJobPortal.Exception.JobPortalValidationException;
import com.example.OnlineJobPortal.entity.BookmarkedFreelancer;
import com.example.OnlineJobPortal.entity.Bookmarkedjob;
import com.example.OnlineJobPortal.service.IBookmarkedJobService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BookmarkedJobController {
	@Autowired
	IBookmarkedJobService bookmarkedJobService;

	@PostMapping("/bookmarkedjobadd")
	public ResponseEntity<Bookmarkedjob> createBookmark(@Valid @RequestBody BookmarkedJobDTO bookmarkedjobdto,
			BindingResult bindingResult) throws FreelancerAlreadyExistsException {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<Bookmarkedjob>( HttpStatus.BAD_REQUEST);
		}
		try {
			Bookmarkedjob b=bookmarkedJobService.bookmarkJob(bookmarkedjobdto);
			return new ResponseEntity<Bookmarkedjob>(b, HttpStatus.OK);
		} catch (InvalidBookmarkedJobException exception) {
			throw new InvalidBookmarkedJobException("One or more entered fields contain invalid objects.");
		}
		

	}


	@DeleteMapping("/bookmarkjobdelete/{id}")
	public ResponseEntity<List<Bookmarkedjob>> deleteById(@PathVariable int id) {
		try {
			List<Bookmarkedjob> bi=	bookmarkedJobService.remove(id);
			return new ResponseEntity<List<Bookmarkedjob>>(bi, HttpStatus.OK);
		} catch (InvalidBookmarkedJobException exception) {
			throw new InvalidBookmarkedJobException("No bookmark with specified id exists.");
		}
		
	}

	@GetMapping("/get/id/{id}")
	public ResponseEntity<Object> getById(@Valid @PathVariable int id) {
		try {
			Bookmarkedjob bookmarkedJob = bookmarkedJobService.findById(id);
			return new ResponseEntity<>(bookmarkedJob, HttpStatus.OK);
		} catch (InvalidBookmarkedJobException exception) {
			throw new InvalidBookmarkedJobException("No Bookmark with specified id.");
		}
	}

	@GetMapping("/bookmarkjobby/{skillName}")
	public List<Bookmarkedjob> listJobsBySkill(@PathVariable String skillName) {
		try {
			List<Bookmarkedjob> bookmarkedJobs = bookmarkedJobService.findBookmarkedJobsBySkillName(skillName);
			return bookmarkedJobs;
		} catch (InvalidBookmarkedJobException exception) {
			throw new InvalidBookmarkedJobException("No bookmarks found for the specified skill name");
		}
	}
	
	@GetMapping("/bookmarkjobfindbyfree/{id}")
	public ResponseEntity<List<Bookmarkedjob>> findByrecId(@PathVariable int id) throws InvalidBookmarkedFreelancerException{
		List<Bookmarkedjob> finded=bookmarkedJobService.findByfreeid(id);
		return new ResponseEntity<List<Bookmarkedjob>>(finded,HttpStatus.OK);
	}


	

}
