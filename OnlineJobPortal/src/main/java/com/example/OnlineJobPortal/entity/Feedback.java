package com.example.OnlineJobPortal.entity;
import javax.persistence.Entity;

@Entity
public class Feedback {
	private long id;
	private int rating;
	private String comment;
	private Recruiter createdBy;
	private Freelancer createdFor;
}
