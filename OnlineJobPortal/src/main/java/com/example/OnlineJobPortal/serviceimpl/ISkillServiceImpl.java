package com.example.OnlineJobPortal.serviceimpl;

import com.example.OnlineJobPortal.Dto.SkillDto;
import com.example.OnlineJobPortal.Exception.FreelancerAlreadyExistsException;
import com.example.OnlineJobPortal.Exception.FreelancerDoesNotExistsException;
import com.example.OnlineJobPortal.entity.Skill;
import com.example.OnlineJobPortal.repository.SkillRepository;
import com.example.OnlineJobPortal.service.ISkillService;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ISkillServiceImpl implements ISkillService {

	@Autowired
	SkillRepository skillRepo;
	
	@Override
	public Skill save(SkillDto skilldto) throws FreelancerAlreadyExistsException {
		// TODO Auto-generated method stub
		if(skillRepo.existsById(skilldto.getId())) {
				throw new FreelancerAlreadyExistsException();
		}
		Skill skill=new Skill();
		skill.setDescription(skilldto.getDescription());
		skill.setId(skilldto.getId());
		skill.setName(skilldto.getName());
		return skillRepo.save(skill);
		
	}

	@Override
	public Skill update(SkillDto skilldto, int id) throws FreelancerDoesNotExistsException {
		// TODO Auto-generated method stub
		if(skillRepo.existsById(skilldto.getId())) {
			Skill skill=new Skill();
			if(Objects.nonNull(skilldto.getDescription())&&!"".equalsIgnoreCase(skilldto.getDescription())) {
				skill.setDescription(skilldto.getDescription());
			}
			if(Objects.nonNull(skilldto.getName())&&!"".equalsIgnoreCase(skilldto.getName())) {
				skill.setName(skilldto.getName());
			}
			
			
			return skillRepo.save(skill);
	}else {
		throw new FreelancerDoesNotExistsException();
	}
		

	}

	@Override
	public List<Skill> remove(int id) throws FreelancerDoesNotExistsException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				if(skillRepo.existsById(id)) {
					
					skillRepo.deleteById(id);
					return skillRepo.findAll();
					
			}else {
				throw new FreelancerDoesNotExistsException();
			}
		
	}

	@Override
	public List<Skill> findAll() {
		// TODO Auto-generated method stub
		return skillRepo.findAll();
	}


}
