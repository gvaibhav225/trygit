package com.example.OnlineJobPortal.serviceimpl;

import java.util.List;

import com.example.OnlineJobPortal.entity.BookmarkedFreelancer;
import com.example.OnlineJobPortal.entity.Freelancer;
import com.example.OnlineJobPortal.entity.Recruiter;
import com.example.OnlineJobPortal.entity.Skill;
import com.example.OnlineJobPortal.service.IBookmarkFreelancerService;

import org.springframework.stereotype.Service;

@Service
public class IBookmarkFreelancerServiceImpl implements IBookmarkFreelancerService{

	@Override
	public BookmarkedFreelancer bookmarkfreelancer(Freelancer freelancer, Skill skill, Recruiter recruiter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookmarkedFreelancer> findBookmarkedFreelancer(Freelancer freelancer, Skill skill,
			Recruiter recruiter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeBookmarkedFreelancer(Freelancer freelancer, Skill skill, Recruiter recruiter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BookmarkedFreelancer findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
