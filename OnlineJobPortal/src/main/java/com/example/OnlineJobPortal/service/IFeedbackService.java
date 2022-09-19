package com.example.OnlineJobPortal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.OnlineJobPortal.Dto.FeedbackDTO;
import com.example.OnlineJobPortal.Dto.FeedbackListDTO;
import com.example.OnlineJobPortal.entity.Feedback;

@Service
public interface IFeedbackService {

	Float averageRating(String id);

	Feedback addFeedback(FeedbackDTO feedbackDto);

	List<FeedbackListDTO> findFeedbacksForFreelancerByRecruiter(String fId, String rId);
}
