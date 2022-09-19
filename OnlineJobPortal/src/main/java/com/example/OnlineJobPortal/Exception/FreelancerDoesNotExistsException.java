package com.example.OnlineJobPortal.Exception;

public class FreelancerDoesNotExistsException extends Exception{
String str;

public FreelancerDoesNotExistsException(String str) {
	super();
	this.str = str;
}

public FreelancerDoesNotExistsException() {
	super();
}
}
