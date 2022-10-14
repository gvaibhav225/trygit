package com.example.OnlineJobPortal.Dto;



import javax.validation.constraints.NotNull;


public class BookmarkedFreelancerDto {
	
    private int id;
	
//    @NotNull(message = "Skill Id cannot be null")
//	private int skillId;
	
    @NotNull(message = "Freelancer Id cannot be null")
	private int freelanceId;
	
    @NotNull(message = "Recruiter Id cannot be null")
	private int recruiterId;

	public BookmarkedFreelancerDto() {
		super();
	}

	public BookmarkedFreelancerDto(int id,
			@NotNull(message = "Freelancer Id cannot be null") int freelanceId,
			@NotNull(message = "Recruiter Id cannot be null") int recruiterId) {
		super();
		this.id = id;
//		this.skillId = skillId;
		this.freelanceId = freelanceId;
		this.recruiterId = recruiterId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
//
//	public int getSkillId() {
//		return skillId;
//	}
//
//	public void setSkillId(int skillId) {
//		this.skillId = skillId;
//	}

	public int getFreelanceId() {
		return freelanceId;
	}

	public void setFreelanceId(int freelanceId) {
		this.freelanceId = freelanceId;
	}

	public int getRecruiterId() {
		return recruiterId;
	}

	public void setRecruiterId(int recruiterId) {
		this.recruiterId = recruiterId;
	}
    
    
}
