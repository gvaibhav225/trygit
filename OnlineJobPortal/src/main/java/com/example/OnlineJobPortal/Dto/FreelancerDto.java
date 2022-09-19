package com.example.OnlineJobPortal.Dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class FreelancerDto {


	private int id;
	
	@NotEmpty(message="firstname cant be empty")
	private String firstName;
	
	@NotEmpty(message="lastname cant be empty")
	private String lastName;
	
	@NotEmpty(message="password cant be empty")
	@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{8,20}$", message="pas should be of more than 8 characters")
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
