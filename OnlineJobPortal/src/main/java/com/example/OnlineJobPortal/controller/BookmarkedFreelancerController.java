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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.OnlineJobPortal.Dto.BookmarkedFreelancerDto;
import com.example.OnlineJobPortal.Dto.FreelancerDto;
import com.example.OnlineJobPortal.Dto.RecruiterDto;
import com.example.OnlineJobPortal.Dto.SkillDto;
import com.example.OnlineJobPortal.Exception.FreelancerDoesNotExistsException;
import com.example.OnlineJobPortal.Exception.InvalidAdminException;
import com.example.OnlineJobPortal.Exception.InvalidBookmarkedFreelancerException;
import com.example.OnlineJobPortal.entity.BookmarkedFreelancer;
import com.example.OnlineJobPortal.entity.Freelancer;
import com.example.OnlineJobPortal.service.IBookmarkFreelancerService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BookmarkedFreelancerController {
	
	@Autowired
	IBookmarkFreelancerService bookmarkFreelancerServ;
	
	@PostMapping("/bookmarkedFreelancersave")
	public ResponseEntity<BookmarkedFreelancer> save(@Valid @RequestBody BookmarkedFreelancerDto bookmarkedFreelancerDto, BindingResult bindingResult) throws
	InvalidBookmarkedFreelancerException {
		
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<BookmarkedFreelancer>( HttpStatus.BAD_REQUEST);
		}
		BookmarkedFreelancer bookFreelancer = bookmarkFreelancerServ.bookmarkfreelancer(bookmarkedFreelancerDto);
		return new ResponseEntity<BookmarkedFreelancer>(bookFreelancer,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/bookmarkfreefinall")
	public ResponseEntity<List<BookmarkedFreelancer>> findBookmarkedFreelancer(){
		List<BookmarkedFreelancer> findall=bookmarkFreelancerServ.findBookmarkedFreelancer();
		return new ResponseEntity<List<BookmarkedFreelancer>>(findall,HttpStatus.CREATED);
	}
	

	@GetMapping("/bookmarkfreefind/{id}")
	public ResponseEntity<Optional<BookmarkedFreelancer>> findById(@PathVariable int id) throws InvalidBookmarkedFreelancerException{
		Optional<BookmarkedFreelancer> finded=bookmarkFreelancerServ.findById(id);
		return new ResponseEntity<Optional<BookmarkedFreelancer>>(finded,HttpStatus.OK);
	}
	
	@DeleteMapping("/bookmarkfreedlt/{id}")
	public ResponseEntity<List<BookmarkedFreelancer>> removeBookmarkedFreelancer(@PathVariable int id) throws InvalidBookmarkedFreelancerException{
		List<BookmarkedFreelancer> lii=bookmarkFreelancerServ.removeBookmarkedFreelancer(id);
		return new ResponseEntity<List<BookmarkedFreelancer>>(lii,HttpStatus.CREATED);
		
	}
	@GetMapping("/bookmarkfreefindbyrec/{id}")
	public ResponseEntity<List<BookmarkedFreelancer>> findByrecId(@PathVariable int id) throws InvalidBookmarkedFreelancerException{
		List<BookmarkedFreelancer> finded=bookmarkFreelancerServ.findByrecId(id);
		return new ResponseEntity<List<BookmarkedFreelancer>>(finded,HttpStatus.OK);
	}


}
