package com.example.OnlineJobPortal.Dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class AdminDto {
	private int id;
	
	@NotEmpty(message = "firstname cannot be empty")
	private String firstname;
	
	@NotEmpty(message = "lastname cannot be empty")
	private String lastname;
	
	@NotEmpty(message = "password cannot be empty")
	@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{8,20}$", message="pas should be of more than 8 characters")
	private String password;

	public AdminDto() {
		super();
	}

	public AdminDto(int id, @NotEmpty(message = "This cannot be empty") String firstname,
			@NotEmpty(message = "This cannot be empty") String lastname,
			@NotEmpty(message = "This cannot be empty") @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{8,20}$", message = "pas should be of more than 8 characters") String password) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
