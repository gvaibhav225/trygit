package com.example.OnlineJobPortal.Dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class JobDto {
	
@NotNull(message="jobid cant be empty")
private int id;

@NotNull(message="recruiterid cant be empty")
private int recruiterid;

@NotNull(message="skillid cant be empty")
private int skillid;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getRecruiterid() {
	return recruiterid;
}

public void setRecruiterid(int recruiterid) {
	this.recruiterid = recruiterid;
}

public int getSkillid() {
	return skillid;
}

public void setSkillid(int skillid) {
	this.skillid = skillid;
}

public JobDto(@NotEmpty(message = "jobid cant be empty") int id,
		@NotEmpty(message = "recruiterid cant be empty") int recruiterid,
		@NotEmpty(message = "skillid cant be empty") int skillid) {
	super();
	this.id = id;
	this.recruiterid = recruiterid;
	this.skillid = skillid;
}

public JobDto() {
	super();
}

}
