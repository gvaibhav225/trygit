package com.example.OnlineJobPortal.Exception;

public class JobDoesNotExistsException extends Exception {
	String str;

	public JobDoesNotExistsException() {
		super();
	}

	public JobDoesNotExistsException(String str) {
		super();
		this.str = str;
	}
	
	

}
