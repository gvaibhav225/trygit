package com.example.OnlineJobPortal.serviceimpl;

import com.example.OnlineJobPortal.Dto.FreelancerDto;
import com.example.OnlineJobPortal.Exception.FreelancerAlreadyExistsException;
import com.example.OnlineJobPortal.Exception.FreelancerDoesNotExistsException;
import com.example.OnlineJobPortal.Exception.InvalidPasswordException;
import com.example.OnlineJobPortal.entity.Freelancer;
import com.example.OnlineJobPortal.repository.FreelancerRepository;
import com.example.OnlineJobPortal.service.IFreelancerService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IFreelancerServiceImpl implements IFreelancerService{

	@Autowired
	public FreelancerRepository freeRepo;
	
	@Override
	public Freelancer save(FreelancerDto freelancerdto) throws FreelancerAlreadyExistsException {
		// TODO Auto-generated method stub
		if(freeRepo.existsById((int) freelancerdto.getId())) {
			throw new FreelancerAlreadyExistsException();
		}
		
		Freelancer saveduser=new Freelancer();
		saveduser.setId(freelancerdto.getId());
		saveduser.setFirstName(freelancerdto.getFirstName());
		saveduser.setLastName(freelancerdto.getLastName());
		saveduser.setPassword(freelancerdto.getPassword());
		
		return freeRepo.save(saveduser);
	}

	@Override
	public Optional<Freelancer> findById(int id) throws FreelancerDoesNotExistsException {
		// TODO Auto-generated method stub
		if(freeRepo.existsById(id)) {
		Optional<Freelancer> finded=freeRepo.findById(id);
		return finded;
		}
		else {
			throw new FreelancerDoesNotExistsException();
		}
	}

	@Override
	public Freelancer update(FreelancerDto freelancerdto,int id) throws FreelancerDoesNotExistsException, InvalidPasswordException {
		if(freeRepo.existsById(id)) {
			Freelancer userpresent=freeRepo.getById(id);
			
			if(Objects.nonNull(freelancerdto.getFirstName())&&freelancerdto.getFirstName()!=""){
				userpresent.setFirstName(freelancerdto.getFirstName());
			}
			if(Objects.nonNull(freelancerdto.getLastName())&&freelancerdto.getLastName()!=""){
				userpresent.setLastName(freelancerdto.getLastName());
			}
		
			if(Objects.nonNull(freelancerdto.getPassword())&&freelancerdto.getPassword()!=""){
				if(freelancerdto.getPassword().matches("^(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{8,20}$")) {
					userpresent.setPassword(freelancerdto.getPassword());
				}else {
					throw new InvalidPasswordException();
				}
				
			}
			
			return freeRepo.save(userpresent);
			
			}
			else {
				throw new FreelancerDoesNotExistsException();
			}
	}

	@Override
	public List<Freelancer> findAll() {
		// TODO Auto-generated method stub
		return freeRepo.findAll();
		}

	@Override
	public List<Freelancer> deletebyid(int id) {
		// TODO Auto-generated method stub
		
		freeRepo.deleteById(id);
		List<Freelancer> f=freeRepo.findAll();
		
		return f ;
	}

	

}
