package com.example.OnlineJobPortal.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class GlobalExceptionHandler{

	@ExceptionHandler(value=FreelancerAlreadyExistsException.class)
	public ResponseEntity<String> FreelancerAlreadyExistsException(FreelancerAlreadyExistsException FreelancerAlreadyExistsException){
		return new ResponseEntity<String>("user already exists", HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value=FreelancerDoesNotExistsException.class)
	public ResponseEntity<String> FreelancerDoesNotExistsException(FreelancerDoesNotExistsException FreelancerDoesNotExistsException){
		return new ResponseEntity<String>("user does not exists", HttpStatus.CONFLICT);
	}
	
	
	@ExceptionHandler(value=InvalidPasswordException.class)
	public ResponseEntity<String> ThisPassCantBeSetException(InvalidPasswordException InvalidPasswordException){
		return new ResponseEntity<String>("Password should be of more than 8 characters", HttpStatus.CONFLICT);
	}
	
	
	
	@ExceptionHandler(value=InvalidAdminException.class)
	public ResponseEntity<String> InvalidAdminException(InvalidAdminException InvalidAdminException){
		return new ResponseEntity<String>("The User doesn't exist , please check the Id", HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value=InvalidBookmarkedFreelancerException.class)
	public ResponseEntity<String> InvalidBookmarkedFreelancerException(InvalidBookmarkedFreelancerException InvalidBookmarkedFreelancerException){
		return new ResponseEntity<String>("The BookmarkedFreelancer doesn't exist", HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value=JobDoesNotExistsException.class)
	public ResponseEntity<String> JobDoesNotExists(JobDoesNotExistsException JobDoesNotExists){
		return new ResponseEntity<String>("The Job doesn't exist", HttpStatus.CONFLICT);
	}

	@ExceptionHandler(value=InvalidFeedbackException.class)
	public ResponseEntity<String> InvalidFeedbackException(InvalidFeedbackException InvalidFeedbackException){
		return new ResponseEntity<String>("The Job doesn't exist", HttpStatus.CONFLICT);
	}
	
}
