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

import com.example.OnlineJobPortal.Dto.AdminDto;
import com.example.OnlineJobPortal.Exception.InvalidAdminException;
import com.example.OnlineJobPortal.Exception.InvalidPasswordException;
import com.example.OnlineJobPortal.entity.Admin;
import com.example.OnlineJobPortal.service.IAdminService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
	
	@Autowired
	IAdminService adminServ;
	
	@PostMapping("/adminSave")
	public ResponseEntity<Admin> save(@Valid @RequestBody AdminDto adminDto, BindingResult bindingResult) throws InvalidAdminException {
		if(bindingResult.hasErrors()) {
			return new ResponseEntity<Admin>(HttpStatus.BAD_REQUEST);
		}
		
		Admin saveAdmin = adminServ.save(adminDto);
		return new ResponseEntity<Admin>(saveAdmin,HttpStatus.CREATED);
	}
	
	@GetMapping("/adminFind/{id}")
	public ResponseEntity<Optional<Admin>> findById(@PathVariable int id) throws InvalidAdminException{
		Optional<Admin> adminFound =adminServ.findById(id);
		return new ResponseEntity<Optional<Admin>>(adminFound,HttpStatus.OK);
	}
	
	@PutMapping("/adminupdate/{id}")
	public ResponseEntity<String> update(@RequestBody AdminDto adminDto, @PathVariable int id) throws InvalidAdminException, InvalidPasswordException {
		Admin adminUpdate = adminServ.update(adminDto, id);
		return new ResponseEntity<String>("Updated",HttpStatus.CREATED);
	}
	
	@GetMapping("/adminFindAll")
	public ResponseEntity<List<Admin>> findAll() throws InvalidAdminException{
		List<Admin> adminFound =adminServ.findAll();
		return new ResponseEntity<List<Admin>>(adminFound,HttpStatus.OK);
	}
	
	
	
	
}
