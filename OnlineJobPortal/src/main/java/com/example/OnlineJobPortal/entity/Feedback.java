package com.example.OnlineJobPortal.entity;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Feedback {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="feedback_id")
	private int id;
	private int rating;
	private String comment;
	
	@ManyToOne(targetEntity=Recruiter.class,cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="recruiter_id")
	@JsonBackReference
	private Recruiter createdBy;
	
	
	@ManyToOne(targetEntity=Freelancer.class,cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="Freelancer_id")
	@JsonBackReference
	private Freelancer createdFor;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public Recruiter getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(Recruiter optional) {
		this.createdBy = optional;
	}


	public Freelancer getCreatedFor() {
		return createdFor;
	}


	public void setCreatedFor(Freelancer createdFor) {
		this.createdFor = createdFor;
	}


	public Feedback(int id, int rating, String comment, Recruiter createdBy, Freelancer createdFor) {
		super();
		this.id = id;
		this.rating = rating;
		this.comment = comment;
		this.createdBy = createdBy;
		this.createdFor = createdFor;
	}


	public Feedback() {
		super();
	}
	
	
}
