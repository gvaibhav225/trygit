package com.example.OnlineJobPortal.service;


import com.example.OnlineJobPortal.Dto.SkillExperienceDto;
import com.example.OnlineJobPortal.Exception.FreelancerAlreadyExistsException;
import com.example.OnlineJobPortal.entity.Skill;
import com.example.OnlineJobPortal.entity.SkillExperience;


public interface ISkillExperienceService {
	public SkillExperience addSkill(SkillExperienceDto skillexdto) throws FreelancerAlreadyExistsException;
	public SkillExperience updateSkillYears(double years,int id);
}
