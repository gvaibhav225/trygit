package com.example.OnlineJobPortal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.OnlineJobPortal.Dto.FeedbackDTO;

import com.example.OnlineJobPortal.entity.Feedback;


public interface IFeedbackService {

	public int averageRating(int freelancerid);

	public Feedback createFeedback(FeedbackDTO feedbackDto);
	
	public List<Feedback> findFeedbacksByFreelancer(int freelancerid);
	

}
