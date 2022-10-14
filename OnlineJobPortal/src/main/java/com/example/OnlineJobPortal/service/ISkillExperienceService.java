package com.example.OnlineJobPortal.service;


import java.util.List;

import com.example.OnlineJobPortal.Dto.SkillExperienceDto;
import com.example.OnlineJobPortal.Exception.FreelancerAlreadyExistsException;
import com.example.OnlineJobPortal.entity.Skill;
import com.example.OnlineJobPortal.entity.SkillExperience;


public interface ISkillExperienceService {
	public SkillExperience addSkill(SkillExperienceDto skillexdto) throws FreelancerAlreadyExistsException;
	public SkillExperience updateSkillYears(SkillExperienceDto skillexdto,int id);
	public List<SkillExperience> findallByfreeId(int id);
}
