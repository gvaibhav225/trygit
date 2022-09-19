package com.example.OnlineJobPortal.Exception;

public class ThisPassCantBeSetException extends Exception {
String str;

public ThisPassCantBeSetException(String str) {
	super();
	this.str = str;
}

public ThisPassCantBeSetException() {
	super();
}

}
