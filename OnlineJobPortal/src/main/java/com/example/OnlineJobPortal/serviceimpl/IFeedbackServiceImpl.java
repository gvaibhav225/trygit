package com.example.OnlineJobPortal.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OnlineJobPortal.repository.FeedbackRepository;
import com.example.OnlineJobPortal.repository.FreelancerRepository;
import com.example.OnlineJobPortal.repository.RecruiterRepository;
import com.example.OnlineJobPortal.Dto.FeedbackDTO;
import com.example.OnlineJobPortal.Dto.FeedbackListDTO;
import com.example.OnlineJobPortal.entity.Feedback;
import com.example.OnlineJobPortal.entity.Freelancer;
import com.example.OnlineJobPortal.entity.Recruiter;
import com.example.OnlineJobPortal.Exception.InvalidFeedbackException;
import com.example.OnlineJobPortal.service.IFeedbackService;

@Service
public class IFeedbackServiceImpl implements IFeedbackService {

	@Autowired
	FeedbackRepository feedbackDao;

	@Autowired
	RecruiterRepository recruiterDao;

	@Autowired
	FreelancerRepository freelancerDao;

	@Override
	public Float averageRating(String id) {
		if (freelancerDao.existsByUserName(id)) {
			return feedbackDao.averageRatings(id);
		} else
			throw new InvalidFeedbackException();
	}

	@Override
	public Feedback addFeedback(FeedbackDTO feedbackDto) {
		System.out.println(feedbackDto.toString());
		if (recruiterDao.existsById((int) feedbackDto.getRecruiterdtoid())
				&& freelancerDao.existsById((int) feedbackDto.getFreelancerdtoid())) {

			Recruiter recruiter = recruiterDao.findByUserName(feedbackDto.getRecruiterUName());
			Freelancer freelancer = freelancerDao.findByUserName(feedbackDto.getFreelancerUName());
			Feedback feedback = new Feedback();

			feedback.setComment(feedbackDto.getComments());
			feedback.setRanges(feedbackDto.getRanges());
			feedback.setCreatedBy(recruiter);
			feedback.setCreatedFor(freelancer);

			return feedbackDao.save(feedback);
		} else
			throw new InvalidFeedbackException();

	}

	@Override
	public List<FeedbackListDTO> findFeedbacksForFreelancerByRecruiter(String fId, String rId) {

		return feedbackDao.findFeedbacksForFreelancerByRecruiterId(fId, rId);
	}

}