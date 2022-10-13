package com.example.OnlineJobPortal.entity;

import java.util.List;

import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Recruiter {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="recruiter_id")
	private int id;
	private String firstName;
	private String lastName;
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	@OneToMany(mappedBy="postedBy",targetEntity = Job.class, cascade = CascadeType.ALL)
//	@JsonManagedReference
//	private List<Job> postedJobs;
	
	@OneToMany(mappedBy="createdBy",targetEntity = Feedback.class, cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Feedback> Feedbacks;
	
	@OneToMany(mappedBy="bookmarkedBy",targetEntity = BookmarkedFreelancer.class, cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<BookmarkedFreelancer> freelancers;

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

//	public List<Job> getPostedJobs() {
//		return postedJobs;
//	}
//
//	public void setPostedJobs(List<Job> postedJobs) {
//		this.postedJobs = postedJobs;
//	}

	public List<Feedback> getFeedbacks() {
		return Feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		Feedbacks = feedbacks;
	}

	public List<BookmarkedFreelancer> getFreelancers() {
		return freelancers;
	}

	public void setFreelancers(List<BookmarkedFreelancer> freelancers) {
		this.freelancers = freelancers;
	}


	public Recruiter() {
		super();
	}

	public Recruiter(int id, String firstName, String lastName, String password, 
			List<Feedback> feedbacks, List<BookmarkedFreelancer> freelancers) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
//		this.postedJobs = postedJobs;
		Feedbacks = feedbacks;
		this.freelancers = freelancers;
	}
	
	
	

}
