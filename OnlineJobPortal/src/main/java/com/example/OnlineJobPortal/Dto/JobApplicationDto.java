package com.example.OnlineJobPortal.Dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class JobApplicationDto {
	@NotNull(message="jobid cant be empty")
	private int jobappdtoid;
	
	public JobApplicationDto(@NotNull(message = "jobid cant be empty") int jobappdtoid,
			@NotNull(message = "jobid cant be empty") int jobid,
			@NotNull(message = "freelancerid cant be empty") int freelancerid,
			@NotEmpty(message = "coverletter cant be empty") String coverLetter) {
		super();
		this.jobappdtoid = jobappdtoid;
		this.jobid = jobid;
		this.freelancerid = freelancerid;
		this.coverLetter = coverLetter;
	}

	@NotNull(message="jobid cant be empty")
	private int jobid;
	
	@NotNull(message="freelancerid cant be empty")
	private int freelancerid;
	
	@NotEmpty(message="coverletter cant be empty")
	private String coverLetter;

	public int getJobid() {
		return jobid;
	}

	public void setJobid(int jobid) {
		this.jobid = jobid;
	}

	public int getFreelancerid() {
		return freelancerid;
	}

	public void setFreelancerid(int freelancerid) {
		this.freelancerid = freelancerid;
	}

	public String getCoverLetter() {
		return coverLetter;
	}

	public void setCoverLetter(String coverLetter) {
		this.coverLetter = coverLetter;
	}

	

	public int getJobappdtoid() {
		return jobappdtoid;
	}

	public void setJobappdtoid(int jobappdtoid) {
		this.jobappdtoid = jobappdtoid;
	}

	public JobApplicationDto() {
		super();
	}
	
	
}
