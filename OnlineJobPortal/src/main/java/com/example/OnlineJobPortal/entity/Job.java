package com.example.OnlineJobPortal.entity;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;

@Entity
public class Job {
	private long id;
	private Skill skill;
	private Recruiter postedBy;
	private LocalDate posteddate;
	private Freelancer awardedTo;
	private List<JobApplication> jobApplications;
	private boolean active;
}
