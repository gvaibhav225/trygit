package com.example.OnlineJobPortal.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.example.OnlineJobPortal.entity.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
	
	
	@Query("select fb from Feedback fb where fb.createdFor.id=:id" )
	public List<Feedback> findFeedbacksForFreelancer(@Param("id") int freelancerid);

	@Query("select AVG(fb.rating) from Feedback fb where fb.createdFor.id = :id")
	public int averageRatings(@Param("id") int freelancerid);
	
}
