package com.example.OnlineJobPortal.entity;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
public class Job {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="job_id")
	private int id;
	
	@OneToOne(targetEntity = Skill.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	private Skill skill;
	
	private String title;
	private String description;
	
	private LocalDate posteddate;
	
//	@OneToOne(targetEntity = Freelancer.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
//	private Freelancer awardedTo;
	
	
	@OneToMany(mappedBy="job",targetEntity = JobApplication.class,cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<JobApplication> jobApplications;
	
	
	@ManyToOne(targetEntity= Recruiter.class,cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="recruiter_id")
	@JsonBackReference
	private Recruiter postedBy;
	
	private boolean active;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public Recruiter getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(Recruiter postedBy) {
		this.postedBy = postedBy;
	}

	public LocalDate getPosteddate() {
		return posteddate;
	}

	public void setPosteddate(LocalDate posteddate) {
		this.posteddate = posteddate;
	}

//	public Freelancer getAwardedTo() {
//		return awardedTo;
//	}
//
//	public void setAwardedTo(Freelancer awardedTo) {
//		this.awardedTo = awardedTo;
//	}

	public List<JobApplication> getJobApplications() {
		return jobApplications;
	}

	public void setJobApplications(List<JobApplication> jobApplications) {
		this.jobApplications = jobApplications;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Job(int id, Skill skill, Recruiter postedBy, String name, String description, LocalDate posteddate, 
			List<JobApplication> jobApplications, boolean active) {
		super();
		this.id = id;
		this.skill = skill;
		this.postedBy = postedBy;
		this.posteddate = posteddate;
//		this.awardedTo = awardedTo;
		this.jobApplications = jobApplications;
		this.active = active;
		this.description=description;
		this.title=title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Job() {
		super();
	}
	
}
