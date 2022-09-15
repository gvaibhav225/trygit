package com.example.OnlineJobPortal.service;

import com.example.OnlineJobPortal.entity.Freelancer;
import com.example.OnlineJobPortal.entity.Skill;
import com.example.OnlineJobPortal.entity.SkillExperience;

public interface ISkillExperienceService {
	public SkillExperience addSkill(Skill skill,Freelancer freelancer,int experienceYears);
	public SkillExperience updateSkillYears(Skill skill,Freelancer freelancer,int experienceYears);
}
