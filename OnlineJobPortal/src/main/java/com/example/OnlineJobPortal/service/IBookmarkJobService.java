package com.example.OnlineJobPortal.service;

import java.util.List;

import com.example.OnlineJobPortal.entity.BookmarkedJob;
import com.example.OnlineJobPortal.entity.Freelancer;
import com.example.OnlineJobPortal.entity.Job;
import com.example.OnlineJobPortal.entity.Skill;

public interface IBookmarkJobService {
	public BookmarkedJob bookmarkedjob(Job job,Freelancer freelancer);
	public void removeBookmark(Job job,Freelancer freelancer);
	public List<BookmarkedJob> findBookmarkedJobsBySkill(Skill skill,Freelancer freelancer);
	public BookmarkedJob findById(int id);
}
