package com.example.OnlineJobPortal.serviceimpl;

import com.example.OnlineJobPortal.Dto.FreelancerDto;
import com.example.OnlineJobPortal.Dto.RecruiterDto;
import com.example.OnlineJobPortal.Exception.FreelancerAlreadyExistsException;
import com.example.OnlineJobPortal.Exception.FreelancerDoesNotExistsException;
import com.example.OnlineJobPortal.Exception.InvalidPasswordException;
import com.example.OnlineJobPortal.entity.Freelancer;
import com.example.OnlineJobPortal.entity.Recruiter;
import com.example.OnlineJobPortal.repository.FreelancerRepository;
import com.example.OnlineJobPortal.repository.RecruiterRepository;
import com.example.OnlineJobPortal.service.IRecruiterService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IRecruiterServiceImpl implements IRecruiterService {



	@Autowired
	public RecruiterRepository reRepo;
	
	@Override
	public Recruiter save(RecruiterDto recruiterdto)  throws FreelancerAlreadyExistsException {
		// TODO Auto-generated method stub
		if(reRepo.existsById((int) recruiterdto.getRecruiterdtoid())) {
			throw new FreelancerAlreadyExistsException();
		}
		
		Recruiter saveduser=new Recruiter();
		saveduser.setId(recruiterdto.getRecruiterdtoid());
		saveduser.setFirstName(recruiterdto.getFirstName());
		saveduser.setLastName(recruiterdto.getLastName());
		saveduser.setPassword(recruiterdto.getPassword());
		
		return reRepo.save(saveduser);
	}

	@Override
	public Optional<Recruiter> findById(int id) throws FreelancerDoesNotExistsException {
		// TODO Auto-generated method stub
		if(reRepo.existsById(id)) {
		Optional<Recruiter> finded=reRepo.findById(id);
		return finded;
		}
		else {
			throw new FreelancerDoesNotExistsException();
		}
	}

	@Override
	public Recruiter update(RecruiterDto recruiterdto, int id)throws FreelancerDoesNotExistsException, InvalidPasswordException {
		if(reRepo.existsById(id)) {
			Recruiter userpresent=reRepo.getById(id);
			
			if(Objects.nonNull(recruiterdto.getFirstName())&&recruiterdto.getFirstName()!=""){
				userpresent.setFirstName(recruiterdto.getFirstName());
			}
			if(Objects.nonNull(recruiterdto.getLastName())&&recruiterdto.getLastName()!=""){
				userpresent.setLastName(recruiterdto.getLastName());
			}
		
			if(Objects.nonNull(recruiterdto.getPassword())&&recruiterdto.getPassword()!=""){
				if(recruiterdto.getPassword().matches("^(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{8,20}$")) {
					userpresent.setPassword(recruiterdto.getPassword());
				}else {
					throw new InvalidPasswordException();
				}
				
			}
			
			return reRepo.save(userpresent);
			
			}
			else {
				throw new FreelancerDoesNotExistsException();
			}

}

	@Override
	public List<Recruiter> findAll() {
		// TODO Auto-generated method stub
		return reRepo.findAll();
	}

	@Override
	public List<Recruiter> deletebyid(int id) {
		// TODO Auto-generated method stub
		reRepo.deleteById(id);		
		return reRepo.findAll();
	}
}
