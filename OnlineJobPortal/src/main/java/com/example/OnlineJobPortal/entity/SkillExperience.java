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
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="skillex_id")
	private int id;
	
	@OneToOne(targetEntity = Skill.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
	private Skill skill;
	private double years;
	
	@ManyToOne(targetEntity=Freelancer.class,cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="Freelancer_id")
	@JsonBackReference
	private Freelancer freelance;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public double getYears() {
		return years;
	}

	public void setYears(double years) {
		this.years = years;
	}

	public Freelancer getFreelance() {
		return freelance;
	}

	public void setFreelance(Freelancer freelance) {
		this.freelance = freelance;
	}

	public SkillExperience(int id, Skill skill, int years, Freelancer freelance) {
		super();
		this.id = id;
		this.skill = skill;
		this.years = years;
		this.freelance = freelance;
	}

	public SkillExperience() {
		super();
	}
	
	
}
