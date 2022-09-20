package com.example.OnlineJobPortal.Dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;


public class SkillDto {

	private int id;
	
	@NotEmpty(message="name cant be empty")
	private String name;
	
	@NotEmpty(message="Desciption cant be empty")
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public SkillDto(int id, @NotEmpty(message = "name cant be empty") String name,
			@NotEmpty(message = "Desciption cant be empty") String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public SkillDto() {
		super();
	}
	

}
