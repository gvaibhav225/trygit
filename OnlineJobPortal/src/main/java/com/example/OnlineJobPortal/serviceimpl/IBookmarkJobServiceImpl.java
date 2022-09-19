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
import com.example.OnlineJobPortal.Dto.BookmarkedJobListDTO;
import com.example.OnlineJobPortal.entity.BookmarkedJob;
import com.example.OnlineJobPortal.entity.Skill;
import com.example.OnlineJobPortal.Exception.InvalidBookmarkedJobException;
import com.example.OnlineJobPortal.service.IBookmarkedJobService;

@Service
public class IBookmarkJobServiceImpl implements IBookmarkedJobService {
	@Autowired
	BookmarkedJobRepository bookmarkedjobdao;
	@Autowired
	SkillRepository skilldao;
	@Autowired
	FreelancerRepository freelancerdao;
	@Autowired
	JobRepository jobdao;

	@Transactional
	public BookmarkedJob bookmarkJob(BookmarkedJobDTO bookmarkedjobdto) {
		BookmarkedJob bookmarkedJob = new BookmarkedJob();

		if (jobdao.existsById(bookmarkedjobdto.getJobId()) &&
				freelancerdao.existsById(bookmarkedjobdto.getFreelancerId()) &&
				skilldao.existsById(bookmarkedjobdto.getSkillId())) {
			bookmarkedJob.setSkill(skilldao.findById(bookmarkedjobdto.getSkillId()).get());
			bookmarkedJob.setFreelancer(freelancerdao.findById(bookmarkedjobdto.getFreelancerId()).get());
			bookmarkedJob.setJob(jobdao.findById(bookmarkedjobdto.getJobId()).get());

			return bookmarkedjobdao.save(bookmarkedJob);
		}

		else {
			throw new InvalidBookmarkedJobException();
		}
	}

	@Override
	@Transactional
	public List<BookmarkedJob> findBookmarkedJobsBySkillName(String name) {
		if (skilldao.existsByName(name)) {
			Skill skill = skilldao.findByName(name);
			return bookmarkedjobdao.findBookmarkedJobBySkill(skill);
		} else
			throw new InvalidBookmarkedJobException();
	}

	@Transactional
	@Override
	public BookmarkedJob findById(Long id) {
		if (bookmarkedjobdao.existsById(id)) {

			return bookmarkedjobdao.findById(id).get();
		} else {
			throw new InvalidBookmarkedJobException();
		}
	}

	@Override
	public Long getCurrentId() {
		return bookmarkedjobdao.getCurrentSeriesId();
	}

	@Transactional
	public void remove(Long BId) {
		if (bookmarkedjobdao.existsById(BId)) {

			BookmarkedJob bj = bookmarkedjobdao.findById(BId).get();
			bookmarkedjobdao.delete(bj);
		} else {
			throw new InvalidBookmarkedJobException();
		}
	}

	@Override
	public List<BookmarkedJobListDTO> findAllBookmarks(Long frId) {
		return bookmarkedjobdao.findAllBookmarks(frId);
	}

}