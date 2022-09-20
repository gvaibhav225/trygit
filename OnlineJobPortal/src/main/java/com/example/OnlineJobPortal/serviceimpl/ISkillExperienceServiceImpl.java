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
	SkillExperience ske=new SkillExperience();
	ske.setFreelance(freeRepo.getById(skillexdto.getFreelancerid()));
	ske.setId(skillexdto.getSkillexid());
	ske.setYears(skillexdto.getYears());
	ske.setSkill(skillRepo.getByName(skillexdto.getSkillname()));
		return skillexRepo.save(ske);
	}

	@Override
	public SkillExperience updateSkillYears(double years, int id) {
		// TODO Auto-generated method stub
		if(skillexRepo.existsById(id)) {
			SkillExperience sk=skillexRepo.getById(id);
			
			if(years>=0) {
				sk.setYears(years);
				
				skillexRepo.save(sk);
			}else {
				throw new InvalidFeedbackException();
			}
			
		}
		
		return null;
	}

}
