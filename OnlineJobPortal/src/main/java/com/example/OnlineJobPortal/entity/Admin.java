package com.example.OnlineJobPortal.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {
	
	@Id
	private int id;
	private String firstName;
	private String lastName;
	private String password;
	
}
