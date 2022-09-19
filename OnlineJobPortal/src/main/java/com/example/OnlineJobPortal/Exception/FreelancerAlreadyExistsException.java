package com.example.OnlineJobPortal.Exception;

public class FreelancerAlreadyExistsException extends Exception {
String str;

public FreelancerAlreadyExistsException() {
	super();
}

public FreelancerAlreadyExistsException(String str) {
	super();
	this.str = str;
}


}
