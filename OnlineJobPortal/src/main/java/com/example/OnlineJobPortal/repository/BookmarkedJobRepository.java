package com.example.OnlineJobPortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.OnlineJobPortal.entity.BookmarkedFreelancer;
import com.example.OnlineJobPortal.entity.Bookmarkedjob;
import com.example.OnlineJobPortal.entity.Skill;

@Repository
public interface BookmarkedJobRepository extends JpaRepository<Bookmarkedjob,Integer>  
{
	

	@Query("select fb from Bookmarkedjob fb where fb.job.skill.name=:name" )
	List<Bookmarkedjob> findBookmarkedJobsBySkillname(@Param("name") String name);

	

	
	@Query("Select j from Bookmarkedjob j where j.freelance.id=:id")
	public List<Bookmarkedjob> findbyfreeid(@Param("id") int id);
}
