package com.example.OnlineJobPortal.service;

import java.util.List;

import com.example.OnlineJobPortal.entity.BookmarkedFreelancer;
import com.example.OnlineJobPortal.entity.Freelancer;
import com.example.OnlineJobPortal.entity.Recruiter;
import com.example.OnlineJobPortal.entity.Skill;

public interface IBookmarkFreelancerService {
	public BookmarkedFreelancer bookmarkfreelancer(Freelancer freelancer,Skill skill,Recruiter recruiter);
	public List<BookmarkedFreelancer> findBookmarkedFreelancer(Freelancer freelancer,Skill skill,Recruiter recruiter);
	public void removeBookmarkedFreelancer(Freelancer freelancer,Skill skill,Recruiter recruiter);
	public BookmarkedFreelancer findById(int id);
}
