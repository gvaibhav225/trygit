package com.example.OnlineJobPortal.entity;

import java.util.List;

import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;

public class Recruiter {
	
	private long id;
	private String firstName;
	private String lastName;
	private List<Job> postedJobs;
	private List<Feedback> Feedbacks;
	private List<BookmarkedFreelancer> freelancers;

}
