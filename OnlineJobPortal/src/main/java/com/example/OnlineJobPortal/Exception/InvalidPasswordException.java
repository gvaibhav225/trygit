package com.example.OnlineJobPortal.Exception;

public class InvalidPasswordException extends Exception {

	String str;

	public InvalidPasswordException(String str) {
		super();
		this.str = str;
	}

	public InvalidPasswordException() {
		super();
	}
	
}
