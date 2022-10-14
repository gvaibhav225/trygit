package com.example.OnlineJobPortal.service;

import java.util.List;

import javax.validation.Valid;

import com.example.OnlineJobPortal.Dto.SkillDto;
import com.example.OnlineJobPortal.Exception.FreelancerAlreadyExistsException;
import com.example.OnlineJobPortal.Exception.FreelancerDoesNotExistsException;
import com.example.OnlineJobPortal.entity.Skill;

public interface ISkillService {
	public Skill save(@Valid SkillDto skilldto) throws FreelancerAlreadyExistsException;
	public Skill update(SkillDto skilldto, int id) throws FreelancerDoesNotExistsException;
	public List<Skill> remove(int id) throws FreelancerDoesNotExistsException;
	public List<Skill> findAll();
	
}
