package com.example.OnlineJobPortal.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class BookmarkedFreelancer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="bookmarkedfree_id")
	private int id;
	
//	@OneToOne(targetEntity = Skill.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
//	private Skill skill;
	
	@OneToOne(targetEntity = Freelancer.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	private Freelancer freelance;
	
	@ManyToOne(targetEntity=Recruiter.class,cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="recruiter_id")
	@JsonBackReference
	private Recruiter bookmarkedBy;

	public BookmarkedFreelancer(int id, Freelancer freelance, Recruiter bookmarkedBy) {
		super();
		this.id = id;
	
		this.freelance = freelance;
		this.bookmarkedBy = bookmarkedBy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	

	public Freelancer getFreelance() {
		return freelance;
	}

	public void setFreelance(Freelancer freelance) {
		this.freelance = freelance;
	}

	public Recruiter getBookmarkedBy() {
		return bookmarkedBy;
	}

	public void setBookmarkedBy(Recruiter bookmarkedBy) {
		this.bookmarkedBy = bookmarkedBy;
	}

	public BookmarkedFreelancer() {
		super();
	}
}
