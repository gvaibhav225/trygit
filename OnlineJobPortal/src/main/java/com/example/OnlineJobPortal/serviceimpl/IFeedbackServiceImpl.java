package com.example.OnlineJobPortal.serviceimpl;

import java.util.List;

import com.example.OnlineJobPortal.entity.Feedback;
import com.example.OnlineJobPortal.entity.Freelancer;
import com.example.OnlineJobPortal.entity.Recruiter;
import com.example.OnlineJobPortal.service.IFeedbackService;

import org.springframework.stereotype.Service;

@Service
public class IFeedbackServiceImpl implements IFeedbackService{

	@Override
	public Feedback createFeedback(Recruiter recruiter, Freelancer freelancer, int rating, String review) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int averageRating(Freelancer freelancer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Feedback> findFeedbacksByFreelancer(Freelancer freelancer) {
		// TODO Auto-generated method stub
		return null;
	}

}
