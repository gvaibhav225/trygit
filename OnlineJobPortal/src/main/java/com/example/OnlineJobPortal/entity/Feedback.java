package com.example.OnlineJobPortal.entity;
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
	
	
}
