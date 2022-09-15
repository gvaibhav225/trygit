package com.example.OnlineJobPortal.service;

import java.util.List;

import com.example.OnlineJobPortal.entity.Feedback;
import com.example.OnlineJobPortal.entity.Freelancer;
import com.example.OnlineJobPortal.entity.Recruiter;

public interface IFeedbackService {
	public Feedback createFeedback(Recruiter recruiter,Freelancer freelancer,int rating,String review);
	public int averageRating(Freelancer freelancer);
	public List<Feedback> findFeedbacksByFreelancer(Freelancer freelancer);
}
