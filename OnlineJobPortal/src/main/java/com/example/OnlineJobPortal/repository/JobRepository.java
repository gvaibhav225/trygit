package com.example.OnlineJobPortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.OnlineJobPortal.entity.Job;
@Repository
public interface JobRepository extends JpaRepository<Job,Integer> {

	
	@Query("Select j from Job j where j.skill.name=:name")
	public List<Job> findJobsBySkill(@Param("name") String name);
	
	
	@Query("Select j from Job j where j.postedBy.id=:id")
	public List<Job> findbyrecid(@Param("id") int id);
	
	@Query("Select j from Job j where j.active=1")
	public List<Job> findByactive();
}
