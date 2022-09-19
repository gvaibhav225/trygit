package com.example.OnlineJobPortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.OnlineJobPortal.Dto.BookmarkedJobListDTO;
import com.example.OnlineJobPortal.entity.BookmarkedJob;
import com.example.OnlineJobPortal.entity.Skill;

@Repository
public interface BookmarkedJobRepository extends JpaRepository<BookmarkedJob,Long>  
{
	@Query("SELECT bj FROM Job j, BookmarkedJob bj"
			+ " WHERE j.id = bj.job.id and bj.skill = :skill")
	List<BookmarkedJob> findBookmarkedJobBySkill(@Param("skill") Skill skill);
	
	List<BookmarkedJob> findBookmarkedJobsBySkillId(Long SId);
	

	@Query(value = "select bkd_job_seq.currval from dual", nativeQuery = true)
	Long getCurrentSeriesId();
	
	@Query("select new com.example.OnlineJobPortal.dto.BookmarkedJobListDTO(bj.id, bj.skill.id, bj.skill.name, bj.freelancer.id, CONCAT(bj.freelancer.firstName,' ', bj.freelancer.lastName) as freelancerName, bj.job.id, bj.job.jobTitle) from BookmarkedJob bj where bj.freelancer.id = :frId order by bj.id")
	List<BookmarkedJobListDTO> findAllBookmarks(@Param("frId") Long frId);
}
