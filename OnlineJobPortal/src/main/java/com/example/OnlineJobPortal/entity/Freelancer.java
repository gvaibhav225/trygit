package com.example.OnlineJobPortal.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Freelancer {
	@Id
	private long id;
	private String firstName,lastName,password;
	
	@OneToMany(targetEntity = JobApplication.class,cascade = { CascadeType.PERSIST,
			CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH })
	private List<JobApplication> appliedJobs;
	
	
	
	private List<Feedback> feedbacks;
	private List<SkillExperience> skills;
	private List<Bookmarkedjob> bookmarkedjobs;
}
