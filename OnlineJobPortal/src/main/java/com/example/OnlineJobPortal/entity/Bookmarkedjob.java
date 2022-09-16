package com.example.OnlineJobPortal.entity;
import javax.persistence.Entity;

@Entity
public class Bookmarkedjob {
	private long id;
	private Skill skill;
	private Job job;
	private Freelancer freelance;
}
