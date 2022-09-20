package com.example.OnlineJobPortal.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OnlineJobPortal.repository.FeedbackRepository;
import com.example.OnlineJobPortal.repository.FreelancerRepository;
import com.example.OnlineJobPortal.repository.RecruiterRepository;
import com.example.OnlineJobPortal.Dto.FeedbackDTO;

import com.example.OnlineJobPortal.entity.Feedback;
import com.example.OnlineJobPortal.entity.Freelancer;
import com.example.OnlineJobPortal.entity.Recruiter;
import com.example.OnlineJobPortal.Exception.InvalidFeedbackException;
import com.example.OnlineJobPortal.service.IFeedbackService;

@Service
public class IFeedbackServiceImpl implements IFeedbackService {

	@Autowired
	FeedbackRepository feedbackRepo;

	@Autowired
	RecruiterRepository recruiterRepo;

	@Autowired
	FreelancerRepository freeRepo;

	@Override
	public int averageRating(int freelancerid) {
		if (freeRepo.existsById(freelancerid)) {
			return feedbackRepo.averageRatings(freelancerid);
		} else
			throw new InvalidFeedbackException();
	}

	@Override
	public Feedback createFeedback(FeedbackDTO feedbackDto) {

//		if (recruiterRepo.existsById( feedbackDto.getRecruiterdtoid()) && freeRepo.existsById( feedbackDto.getFreelancerdtoid())  {

      // if(recruiterRepo.existsById(feedbackDto.getRecruiterdtoid())&& freeRepo.existsById(feedbackDto.getFreelancerdtoid())) {
			Feedback feedback = new Feedback();

			feedback.setComment(feedbackDto.getComments());
			feedback.setRating(feedbackDto.getRatings());
			
	        feedback.setCreatedFor(freeRepo.getById(feedbackDto.getFreelancerdtoid()));
	        feedback.setCreatedBy(recruiterRepo.getById(feedbackDto.getRecruiterdtoid()));
			feedback.setId(feedbackDto.getFeedbackdtoid());

			return feedbackRepo.save(feedback);
			
//		} else {
//			throw new InvalidFeedbackException();
//		}
	}

	@Override
       public List<Feedback> findFeedbacksByFreelancer(int freelancerid){

		return feedbackRepo.findFeedbacksForFreelancer(freelancerid);
	}

}