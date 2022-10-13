package com.example.OnlineJobPortal.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Freelancer {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="Freelancer_id")
	private int id;
	private String firstName,lastName,password;
	
	@OneToMany(mappedBy="freelance",targetEntity = JobApplication.class,cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<JobApplication> appliedJobs;
	
	
	@OneToMany(mappedBy="createdFor",targetEntity = Feedback.class,cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Feedback> feedbacks;
	
	@OneToMany(mappedBy="freelance",targetEntity = SkillExperience.class,cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<SkillExperience> skillsexp;
	
	@OneToMany(mappedBy="freelance",targetEntity = Bookmarkedjob.class,cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Bookmarkedjob> bookmarkedjobs;

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

	public List<JobApplication> getAppliedJobs() {
		return appliedJobs;
	}

	public void setAppliedJobs(List<JobApplication> appliedJobs) {
		this.appliedJobs = appliedJobs;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public List<SkillExperience> getSkills() {
		return skillsexp;
	}

	public void setSkills(List<SkillExperience> skillsexp) {
		this.skillsexp = skillsexp;
	}

	public List<Bookmarkedjob> getBookmarkedjobs() {
		return bookmarkedjobs;
	}

	public void setBookmarkedjobs(List<Bookmarkedjob> bookmarkedjobs) {
		this.bookmarkedjobs = bookmarkedjobs;
	}

	public Freelancer(int id, String firstName, String lastName, String password, List<JobApplication> appliedJobs,
			List<Feedback> feedbacks, List<SkillExperience> skills, List<Bookmarkedjob> bookmarkedjobs) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.appliedJobs = appliedJobs;
		this.feedbacks = feedbacks;
		this.skillsexp = skills;
		this.bookmarkedjobs = bookmarkedjobs;
	}

	public Freelancer() {
		super();
	}
	
}
