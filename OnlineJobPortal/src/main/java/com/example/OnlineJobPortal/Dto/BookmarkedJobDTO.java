package com.example.OnlineJobPortal.Dto;

import javax.validation.constraints.NotNull;

public class BookmarkedJobDTO {
	@NotNull(message = "Skill_id cannot be null")
	private Integer skillId;

	@NotNull(message = "freelancer_id cannot be null")
	private Integer freelancerId;

	@NotNull(message = "job_id cannot be null")
	private Integer jobId;

	public BookmarkedJobDTO() {
		super();
	}

	public BookmarkedJobDTO(@NotNull(message = "Skill_id cannot be null") Integer skillId,
			@NotNull(message = "freelancer_id cannot be null") Integer freelancerId,
			@NotNull(message = "job_id cannot be null") Integer jobId) {
		super();
		this.skillId = skillId;
		this.freelancerId = freelancerId;
		this.jobId = jobId;
	}

	public Integer getFreelancerId() {
		return freelancerId;
	}

	public Integer getJobId() {
		return jobId;
	}

	public Integer getSkillId() {
		return skillId;
	}

	public void setFreelancerId(@NotNull(message = "freelancer_id cannot be null") Integer freelancerId) {
		this.freelancerId = freelancerId;
	}

	public void setJobId(@NotNull(message = "job_id cannot be null") Integer jobId) {
		this.jobId = jobId;
	}

	public void setSkillId(@NotNull(message = "Skill_id cannot be null") Integer skillId) {
		this.skillId = skillId;
	}

}
