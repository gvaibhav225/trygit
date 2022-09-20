package com.example.OnlineJobPortal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.OnlineJobPortal.Dto.FeedbackDTO;
import com.example.OnlineJobPortal.Exception.InvalidFeedbackException;
import com.example.OnlineJobPortal.service.IFeedbackService;

@RestController
public class FeedbackController {

    @Autowired
    IFeedbackService feedbackService;

    @PostMapping("/feedbackadd")
    public ResponseEntity<String> addFeedback(@RequestBody FeedbackDTO feedbackDto) {
        feedbackService.createFeedback(feedbackDto);
        return new ResponseEntity<String>("Feedback Added Successfully", HttpStatus.OK);
    }   
                                                      
    @GetMapping("/get/freelancer/{freelancerUId}/recruiter/{recruiterId}")
    public ResponseEntity<Object> getFeedbackForFreelancerByRecruiter(@PathVariable int freelancerid) {
        try { 
            return new ResponseEntity<>(
                    feedbackService.findFeedbacksByFreelancer(freelancerid), HttpStatus.OK);
        } catch (InvalidFeedbackException exception) {
            throw new InvalidFeedbackException("Freelancer with given Id not found");
        }
    }

    @GetMapping("/getavgRatingsFor/{id}")
    public ResponseEntity<Object> getAverageRatings(@PathVariable int id) {
        try {
            return new ResponseEntity<>(feedbackService.averageRating(id), HttpStatus.OK);
        } catch (InvalidFeedbackException exception) {
            throw new InvalidFeedbackException("Freelancer with given Id not found");
        }
    }
}
