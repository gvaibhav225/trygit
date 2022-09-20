package com.example.OnlineJobPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.OnlineJobPortal.entity.SkillExperience;

@Repository
public interface SkillExperienceRepository extends JpaRepository<SkillExperience, Integer> {

}
