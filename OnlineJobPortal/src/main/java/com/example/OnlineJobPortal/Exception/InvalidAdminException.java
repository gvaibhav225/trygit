package com.example.OnlineJobPortal.Exception;

public class InvalidAdminException extends Exception {
	
	String str;

	public InvalidAdminException(String str) {
		super();
		this.str = str;
	}

	public InvalidAdminException() {
		super();
	}



}
