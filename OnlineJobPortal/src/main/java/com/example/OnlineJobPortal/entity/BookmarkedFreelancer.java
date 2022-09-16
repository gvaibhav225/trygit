package com.example.OnlineJobPortal.entity;

import javax.persistence.Entity;

@Entity
public class BookmarkedFreelancer {
	private long id;
	private Skill skill;
	private Freelancer freelance;
	private Recruiter bookmarkedBy;
}
