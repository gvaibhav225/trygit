package com.example.OnlineJobPortal.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value=FreelancerAlreadyExistsException.class)
	public ResponseEntity<String> FreelancerAlreadyExistsException(FreelancerAlreadyExistsException FreelancerAlreadyExistsException){
		return new ResponseEntity<String>("user already exists", HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value=FreelancerDoesNotExistsException.class)
	public ResponseEntity<String> FreelancerDoesNotExistsException(FreelancerDoesNotExistsException FreelancerDoesNotExistsException){
		return new ResponseEntity<String>("user does not exists", HttpStatus.CONFLICT);
	}
	
	
	@ExceptionHandler(value=ThisPassCantBeSetException.class)
	public ResponseEntity<String> ThisPassCantBeSetException(ThisPassCantBeSetException ThisPassCantBeSetException){
		return new ResponseEntity<String>("Password should be of more than 8 characters", HttpStatus.CONFLICT);
	}
	
}
