package com.example.OnlineJobPortal.service;

import java.util.List;
import java.util.Optional;

import com.example.OnlineJobPortal.Dto.BookmarkedFreelancerDto;
import com.example.OnlineJobPortal.Dto.FreelancerDto;
import com.example.OnlineJobPortal.Dto.RecruiterDto;
import com.example.OnlineJobPortal.Dto.SkillDto;
import com.example.OnlineJobPortal.Exception.InvalidBookmarkedFreelancerException;
import com.example.OnlineJobPortal.entity.BookmarkedFreelancer;
import com.example.OnlineJobPortal.entity.Freelancer;

public interface IBookmarkFreelancerService {
	public BookmarkedFreelancer bookmarkfreelancer(BookmarkedFreelancerDto bookmarkedFreelancerDto) throws InvalidBookmarkedFreelancerException;
	public List<BookmarkedFreelancer> findBookmarkedFreelancer();
	public List<BookmarkedFreelancer> removeBookmarkedFreelancer(int id) throws InvalidBookmarkedFreelancerException;
	public Optional<BookmarkedFreelancer> findById(int id) throws InvalidBookmarkedFreelancerException;
	public List<BookmarkedFreelancer> findByrecId(int id);
}
