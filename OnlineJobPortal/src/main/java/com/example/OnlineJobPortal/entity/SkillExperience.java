package com.example.OnlineJobPortal.entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class SkillExperience {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="skillex_id")
	private int id;
	
	@OneToOne(targetEntity = Skill.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	private Skill skill;
	private int years;
	
	@ManyToOne(targetEntity=Freelancer.class,cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="Freelancer_id")
	@JsonBackReference
	private Freelancer freelance;
	
}
