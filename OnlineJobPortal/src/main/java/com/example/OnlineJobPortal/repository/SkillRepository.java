package com.example.OnlineJobPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.OnlineJobPortal.entity.Skill;
import com.example.OnlineJobPortal.entity.SkillExperience;
@Repository
public interface SkillRepository extends JpaRepository<Skill,Integer> {

	@Query("Select s from Skill s where s.name=:name")
	public boolean existsByName(@Param("name") String name);
	
	@Query("Select s from Skill s where s.name=:name")
	public Skill getByName(@Param("name") String name);

}
