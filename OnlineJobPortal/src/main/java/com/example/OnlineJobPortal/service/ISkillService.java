package com.example.OnlineJobPortal.service;

import com.example.OnlineJobPortal.entity.Skill;

public interface ISkillService {
	public Skill save(Skill skill);
	public Skill update(Skill skill);
	public void remove(Skill skill);
}
