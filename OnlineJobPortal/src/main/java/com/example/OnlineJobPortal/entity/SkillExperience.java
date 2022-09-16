package com.example.OnlineJobPortal.entity;
import javax.persistence.Entity;

@Entity
public class SkillExperience {
	private long id;
	private Skill skill;
	private int years;
	private Freelancer freelancer;
}
