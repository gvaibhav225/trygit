package com.example.OnlineJobPortal.entity;

import java.util.List;

public class Freelancer {
	private long id;
	private String firstName,lastName,password;
	private List<JobApplication> appliedJobs;
	private List<Feedback> feedbacks;
	private List<SkillExperience> skills;
	private List<Bookmarkedjob> bookmarkedjobs;
}
