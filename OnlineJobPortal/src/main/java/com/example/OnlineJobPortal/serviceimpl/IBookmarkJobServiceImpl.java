package com.example.OnlineJobPortal.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.OnlineJobPortal.repository.BookmarkedJobRepository;
import com.example.OnlineJobPortal.repository.FreelancerRepository;
import com.example.OnlineJobPortal.repository.JobRepository;
import com.example.OnlineJobPortal.repository.SkillRepository;
import com.example.OnlineJobPortal.Dto.BookmarkedJobDTO;
import com.example.OnlineJobPortal.entity.Bookmarkedjob;
import com.example.OnlineJobPortal.entity.Skill;
import com.example.OnlineJobPortal.Exception.FreelancerAlreadyExistsException;
import com.example.OnlineJobPortal.Exception.InvalidBookmarkedJobException;
import com.example.OnlineJobPortal.service.IBookmarkedJobService;

@Service
public class IBookmarkJobServiceImpl implements IBookmarkedJobService {
	@Autowired
	BookmarkedJobRepository bookmarkedjobRepo;
	@Autowired
	SkillRepository skillRepo;
	@Autowired
	FreelancerRepository freelancerRepo;
	@Autowired
	JobRepository jobRepo;

	@Override
	public Bookmarkedjob bookmarkJob(BookmarkedJobDTO bookmarkedjobdto) throws FreelancerAlreadyExistsException {
		Bookmarkedjob bookmarkedJob = new Bookmarkedjob();

//		if(bookmarkedjobRepo.existsById(bookmarkedjobdto.getBookmaryjobId())) {
//			throw new FreelancerAlreadyExistsException();
//		}
		
		if (jobRepo.existsById(bookmarkedjobdto.getJobId()) &&
				freelancerRepo.existsById(bookmarkedjobdto.getFreelancerId())) {
//			bookmarkedJob.setSkill(skillRepo.findById(bookmarkedjobdto.getSkillId()).get());
			bookmarkedJob.setFreelance(freelancerRepo.findById(bookmarkedjobdto.getFreelancerId()).get());
			bookmarkedJob.setJob(jobRepo.findById(bookmarkedjobdto.getJobId()).get());
//			bookmarkedJob.setId(bookmarkedjobdto.getBookmaryjobId());
			return bookmarkedjobRepo.save(bookmarkedJob);
		}
		else {
			throw new InvalidBookmarkedJobException();
		}
	}

	@Override
	public List<Bookmarkedjob> findBookmarkedJobsBySkillName(String name) {
	if(bookmarkedjobRepo.findBookmarkedJobsBySkillname(name).isEmpty()) {
		throw new InvalidBookmarkedJobException();
			
		} else {
			return  bookmarkedjobRepo.findBookmarkedJobsBySkillname(name);
	}
	}

	@Override
	public Bookmarkedjob findById(int id) {
		if (bookmarkedjobRepo.existsById(id)) {

			return bookmarkedjobRepo.findById(id).get();
		} else {
			throw new InvalidBookmarkedJobException();
		}
	}


	@Override
	public List<Bookmarkedjob>  remove(int BId) {
		if (bookmarkedjobRepo.existsById(BId)) {

			bookmarkedjobRepo.deleteById(BId);
			
			return bookmarkedjobRepo.findAll();
		} else {
			throw new InvalidBookmarkedJobException();
		}
	}

	@Override
	public List<Bookmarkedjob> findByfreeid(int id) {
		// TODO Auto-generated method stub
		return bookmarkedjobRepo.findbyfreeid(id);
	}


}