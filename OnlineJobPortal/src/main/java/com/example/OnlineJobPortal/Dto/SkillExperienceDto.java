package com.example.OnlineJobPortal.Dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SkillExperienceDto {

	
	private int skillexid;
	
	@NotEmpty(message="skillname cant be empty")
	private String skillname;
	
	@NotNull(message="id cant be empty")
	private int freelancerid;
	
	@NotNull(message="years cant be empty")
	private double years;
	public int getSkillexid() {
		return skillexid;
	}
	public void setSkillexid(int skillexid) {
		this.skillexid = skillexid;
	}
	public String getSkillname() {
		return skillname;
	}
	public void setSkillname(String skillname) {
		this.skillname = skillname;
	}
	public int getFreelancerid() {
		return freelancerid;
	}
	public void setFreelancerid(int freelancerid) {
		this.freelancerid = freelancerid;
	}
	public double getYears() {
		return years;
	}
	public void setYears(double years) {
		this.years = years;
	}
	public SkillExperienceDto(int skillexid, String skillname, int freelancerid, double years) {
		super();
		this.skillexid = skillexid;
		this.skillname = skillname;
		this.freelancerid = freelancerid;
		this.years = years;
	}
	public SkillExperienceDto() {
		super();
	}
	
}
