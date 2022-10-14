package com.example.OnlineJobPortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.OnlineJobPortal.entity.JobApplication;
import com.example.OnlineJobPortal.entity.SkillExperience;

@Repository
public interface SkillExperienceRepository extends JpaRepository<SkillExperience, Integer> {

	
	

	@Query("Select j from SkillExperience j where j.freelance.id=:id")
	public List<SkillExperience> skillfindbyfreeid(@Param("id") int id);
}
