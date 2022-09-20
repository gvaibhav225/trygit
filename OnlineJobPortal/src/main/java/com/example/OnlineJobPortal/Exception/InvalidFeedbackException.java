package com.example.OnlineJobPortal.Exception;

public class InvalidFeedbackException extends RuntimeException {

	public InvalidFeedbackException() {
		super();
	}
String message;
	public InvalidFeedbackException(String message) {
		super(message);
	}

}
