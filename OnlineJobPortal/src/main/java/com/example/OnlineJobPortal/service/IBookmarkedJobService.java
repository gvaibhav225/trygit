package com.example.OnlineJobPortal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.OnlineJobPortal.Dto.BookmarkedJobDTO;
import com.example.OnlineJobPortal.Exception.FreelancerAlreadyExistsException;
import com.example.OnlineJobPortal.entity.Bookmarkedjob;



@Service
public interface IBookmarkedJobService {

public	Bookmarkedjob bookmarkJob(BookmarkedJobDTO bookmarkedjobdto) throws FreelancerAlreadyExistsException;
public List<Bookmarkedjob> findBookmarkedJobsBySkillName(String name);
public Bookmarkedjob findById(int id);
List<Bookmarkedjob> remove(int BId);
public List<Bookmarkedjob> findByfreeid(int id);

}











//package com.example.OnlineJobPortal.service;
//
//import java.util.List;
//
//import com.example.OnlineJobPortal.entity.Bookmarkedjob;
//import com.example.OnlineJobPortal.entity.Freelancer;
//import com.example.OnlineJobPortal.entity.Job;
//import com.example.OnlineJobPortal.entity.Skill;
//
//public interface IBookmarkJobService {
//	public Bookmarkedjob bookmarkedjob(Job job,Freelancer freelancer);
//	public void removeBookmark(Job job,Freelancer freelancer);
//	public List<Bookmarkedjob> findBookmarkedJobsBySkill(Skill skill,Freelancer freelancer);
//	public Bookmarkedjob findById(int id);
//}

