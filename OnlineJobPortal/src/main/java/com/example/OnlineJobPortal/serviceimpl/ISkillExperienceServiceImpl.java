package com.example.OnlineJobPortal.serviceimpl;

import com.example.OnlineJobPortal.Dto.SkillExperienceDto;
import com.example.OnlineJobPortal.Exception.FreelancerAlreadyExistsException;
import com.example.OnlineJobPortal.Exception.InvalidFeedbackException;
import com.example.OnlineJobPortal.entity.Freelancer;
import com.example.OnlineJobPortal.entity.Skill;
import com.example.OnlineJobPortal.entity.SkillExperience;
import com.example.OnlineJobPortal.repository.FreelancerRepository;
import com.example.OnlineJobPortal.repository.SkillExperienceRepository;
import com.example.OnlineJobPortal.repository.SkillRepository;
import com.example.OnlineJobPortal.service.ISkillExperienceService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ISkillExperienceServiceImpl implements ISkillExperienceService {

	@Autowired
	public SkillExperienceRepository skillexRepo;
	
	@Autowired
	public SkillRepository skillRepo;
	
	@Autowired
	public FreelancerRepository freeRepo;

	
	
	@Override
	public SkillExperience addSkill(SkillExperienceDto skillexdto) throws FreelancerAlreadyExistsException {
		// TODO Auto-generated method stub  
	if(skillexRepo.existsById(skillexdto.getSkillexid())) {
		throw new FreelancerAlreadyExistsException();
	}
	if(freeRepo.existsById(skillexdto.getFreelancerid())) {
	SkillExperience ske=new SkillExperience();
	ske.setFreelance(freeRepo.getById(skillexdto.getFreelancerid()));
	ske.setId(skillexdto.getSkillexid());
	ske.setYears(skillexdto.getYears());
	ske.setSkill(skillRepo.getByName(skillexdto.getSkillname()));
		return skillexRepo.save(ske);
	}else {
		throw new FreelancerAlreadyExistsException();
	}
	}

	@Override
	public SkillExperience updateSkillYears(SkillExperienceDto skillexdto, int id) {
		// TODO Auto-generated method stub
		if(skillexRepo.existsById(id)) {
			SkillExperience sk=skillexRepo.getById(id);
			
			if(skillexdto.getYears()>=0) {
				sk.setYears(skillexdto.getYears());
				
				skillexRepo.save(sk);
			}else {
				throw new InvalidFeedbackException();
			}
			
		}
		
		return null;
	}

	@Override
	public List<SkillExperience> findallByfreeId(int id) {
		// TODO Auto-generated method stub
		return skillexRepo.skillfindbyfreeid(id);
	}

}
