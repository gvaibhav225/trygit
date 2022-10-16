package com.example.OnlineJobPortal.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.OnlineJobPortal.Dto.BookmarkedFreelancerDto;
import com.example.OnlineJobPortal.Dto.FreelancerDto;
import com.example.OnlineJobPortal.Dto.RecruiterDto;
import com.example.OnlineJobPortal.Dto.SkillDto;
import com.example.OnlineJobPortal.Exception.InvalidBookmarkedFreelancerException;
import com.example.OnlineJobPortal.entity.BookmarkedFreelancer;
import com.example.OnlineJobPortal.repository.BookmarkedFreelancerRepository;
import com.example.OnlineJobPortal.repository.FreelancerRepository;
import com.example.OnlineJobPortal.repository.RecruiterRepository;
import com.example.OnlineJobPortal.repository.SkillRepository;
import com.example.OnlineJobPortal.service.IBookmarkFreelancerService;

@Service
public class IBookmarkFreelancerServiceImpl implements IBookmarkFreelancerService{
	
	@Autowired
	private BookmarkedFreelancerRepository bookmarkFreeRepo;
	
	@Autowired
	private FreelancerRepository freeRepo;
	
	@Autowired
	private SkillRepository skillRepo;
	
	@Autowired
	private RecruiterRepository recruiterRepo;

	@Override
	public Optional<BookmarkedFreelancer> findById(int id) throws InvalidBookmarkedFreelancerException {
		// TODO Auto-generated method stub
		if(bookmarkFreeRepo.existsById(id)) {
			return bookmarkFreeRepo.findById(id);
		}
		else {
			throw new InvalidBookmarkedFreelancerException();
		}
	}

	@Override
	public BookmarkedFreelancer bookmarkfreelancer(BookmarkedFreelancerDto bookmarkedFreelancerDto) throws InvalidBookmarkedFreelancerException {
		// TODO Auto-generated method stub
	if(bookmarkFreeRepo.existsById(bookmarkedFreelancerDto.getId())){
		throw new InvalidBookmarkedFreelancerException();
	}
		BookmarkedFreelancer bookmarked = new BookmarkedFreelancer();
		if(freeRepo.existsById(bookmarkedFreelancerDto.getFreelanceId()) && recruiterRepo.existsById(bookmarkedFreelancerDto.getRecruiterId())
				) {
			bookmarked.setBookmarkedBy(recruiterRepo.findById(bookmarkedFreelancerDto.getRecruiterId()).get());
			bookmarked.setFreelance(freeRepo.findById(bookmarkedFreelancerDto.getFreelanceId()).get());
//			bookmarked.setSkill(skillRepo.findById(bookmarkedFreelancerDto.getSkillId()).get());
			bookmarked.setId(bookmarkedFreelancerDto.getId());
			return bookmarkFreeRepo.save(bookmarked);
		}
		else {
			throw new InvalidBookmarkedFreelancerException();
		}
	}



	@Override
	public List<BookmarkedFreelancer> removeBookmarkedFreelancer(int id) throws InvalidBookmarkedFreelancerException {
		// TODO Auto-generated method stub
		if(bookmarkFreeRepo.existsById(id)) {
			bookmarkFreeRepo.deleteById(id);
			return bookmarkFreeRepo.findAll();
		}
		else {
			throw new InvalidBookmarkedFreelancerException();
		}
		
	}

	@Override
	public List<BookmarkedFreelancer> findBookmarkedFreelancer() {
		// TODO Auto-generated method stub
		return bookmarkFreeRepo.findAll();
	}

	@Override
	public List<BookmarkedFreelancer> findByrecId(int id) {
		// TODO Auto-generated method stub
		return bookmarkFreeRepo.findbyrecid(id);
	}

	
}
