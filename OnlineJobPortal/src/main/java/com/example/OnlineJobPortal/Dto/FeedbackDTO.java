package com.example.OnlineJobPortal.Dto;

public class FeedbackDTO {
	
	
	private int recruiterdtoid;
	private int Freelancerdtoid;
	private int ratings;
	private String comments;
	private int feedbackdtoid;

	public FeedbackDTO() {
		super();
	}

	public int getRecruiterdtoid() {
		return recruiterdtoid;
	}

	public void setRecruiterdtoid(int recruiterdtoid) {
		this.recruiterdtoid = recruiterdtoid;
	}

	public int getFreelancerdtoid() {
		return Freelancerdtoid;
	}

	public void setFreelancerdtoid(int freelancerdtoid) {
		Freelancerdtoid = freelancerdtoid;
	}

	public Integer getRatings() {
		return ratings;
	}

	public void setRatings(Integer ratings) {
		this.ratings = ratings;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getFeedbackdtoid() {
		return feedbackdtoid;
	}

	public void setFeedbackdtoid(int feedbackdtoid) {
		this.feedbackdtoid = feedbackdtoid;
	}

	public FeedbackDTO(int recruiterdtoid, int freelancerdtoid, Integer ratings, String comments, int feedbackdtoid) {
		super();
		this.recruiterdtoid = recruiterdtoid;
		Freelancerdtoid = freelancerdtoid;
		this.ratings = ratings;
		this.comments = comments;
		this.feedbackdtoid = feedbackdtoid;
	}
	
	
}