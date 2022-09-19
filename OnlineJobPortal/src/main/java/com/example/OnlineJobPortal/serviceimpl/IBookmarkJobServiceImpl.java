package com.example.OnlineJobPortal.serviceimpl;

import java.util.List;

import com.example.OnlineJobPortal.entity.Bookmarkedjob;
import com.example.OnlineJobPortal.entity.Freelancer;
import com.example.OnlineJobPortal.entity.Job;
import com.example.OnlineJobPortal.entity.Skill;
import com.example.OnlineJobPortal.service.IBookmarkJobService;

import org.springframework.stereotype.Service;

@Service
public class IBookmarkJobServiceImpl implements IBookmarkJobService {

	@Override
	public Bookmarkedjob bookmarkedjob(Job job, Freelancer freelancer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeBookmark(Job job, Freelancer freelancer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Bookmarkedjob> findBookmarkedJobsBySkill(Skill skill, Freelancer freelancer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bookmarkedjob findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
