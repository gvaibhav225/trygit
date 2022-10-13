package com.example.OnlineJobPortal.entity;

import java.time.LocalDateTime;

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
public class JobApplication {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="jobapp_id")
	private int id;
	
	@ManyToOne(targetEntity=Freelancer.class,cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="job_id")
	@JsonBackReference
	private Job job;
	private LocalDateTime appliedDate;
	private String coverLetter;
	
	@ManyToOne(targetEntity=Freelancer.class,cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="Freelancer_id")
	@JsonBackReference
	private Freelancer freelance;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public LocalDateTime getAppliedDate() {
		return appliedDate;
	}
	public void setAppliedDate(LocalDateTime appliedDate) {
		this.appliedDate = appliedDate;
	}
	public String getCoverLetter() {
		return coverLetter;
	}
	public void setCoverLetter(String coverLetter) {
		this.coverLetter = coverLetter;
	}
	public Freelancer getFreelance() {
		return freelance;
	}
	public void setFreelance(Freelancer freelance) {
		this.freelance = freelance;
	}
	public JobApplication(int id, Job job, LocalDateTime appliedDate, String coverLetter, Freelancer freelance) {
		super();
		this.id = id;
		this.job = job;
		this.appliedDate = appliedDate;
		this.coverLetter = coverLetter;
		this.freelance = freelance;
	}
	public JobApplication() {
		super();
	}
	
	
}
