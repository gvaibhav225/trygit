package com.example.OnlineJobPortal.service;

import java.util.List;

import com.example.OnlineJobPortal.entity.Bookmarkedjob;
import com.example.OnlineJobPortal.entity.Freelancer;
import com.example.OnlineJobPortal.entity.Job;
import com.example.OnlineJobPortal.entity.Skill;

public interface IBookmarkJobService {
	public Bookmarkedjob bookmarkedjob(Job job,Freelancer freelancer);
	public void removeBookmark(Job job,Freelancer freelancer);
	public List<Bookmarkedjob> findBookmarkedJobsBySkill(Skill skill,Freelancer freelancer);
	public Bookmarkedjob findById(long id);
}
