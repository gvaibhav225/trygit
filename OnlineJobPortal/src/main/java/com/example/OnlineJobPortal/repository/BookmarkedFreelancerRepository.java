package com.example.OnlineJobPortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.OnlineJobPortal.entity.BookmarkedFreelancer;
import com.example.OnlineJobPortal.entity.Job;
@Repository
public interface BookmarkedFreelancerRepository extends JpaRepository<BookmarkedFreelancer,Integer> {

	
	@Query("Select j from BookmarkedFreelancer j where j.bookmarkedBy.id=:id")
	public List<BookmarkedFreelancer> findbyrecid(@Param("id") int id);
}
