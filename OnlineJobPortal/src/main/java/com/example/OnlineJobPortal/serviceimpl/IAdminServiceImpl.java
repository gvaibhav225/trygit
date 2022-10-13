package com.example.OnlineJobPortal.serviceimpl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OnlineJobPortal.Dto.AdminDto;
import com.example.OnlineJobPortal.Exception.FreelancerAlreadyExistsException;
import com.example.OnlineJobPortal.Exception.FreelancerDoesNotExistsException;
import com.example.OnlineJobPortal.Exception.InvalidAdminException;
import com.example.OnlineJobPortal.Exception.InvalidPasswordException;
import com.example.OnlineJobPortal.entity.Admin;
import com.example.OnlineJobPortal.entity.Freelancer;
import com.example.OnlineJobPortal.repository.AdminRepository;
import com.example.OnlineJobPortal.service.IAdminService;

@Service
public class IAdminServiceImpl implements IAdminService{
	
	@Autowired
	private AdminRepository adminRepo;
	
	@Override
	public Admin save(AdminDto adminDto) throws InvalidAdminException {
		// TODO Auto-generated method stub
		if(adminRepo.existsById( adminDto.getId())) {
			throw new InvalidAdminException();
		}
		
		Admin admin = new Admin();
		admin.setId(adminDto.getId());
		admin.setFirstName(adminDto.getFirstname());
		admin.setLastName(adminDto.getLastname());
		admin.setPassword( adminDto.getPassword());
		
			return adminRepo.save(admin);
		} 
	

	@Override
	public Optional<Admin> findById(int id) throws InvalidAdminException {
		// TODO Auto-generated method stub
		if(adminRepo.existsById(id)) {
			Optional<Admin> adminFound = adminRepo.findById(id);
			return adminFound;
		}
		else {
			throw new InvalidAdminException();
		}
	}

	@Override
	public Admin update(AdminDto adminDto, int id) throws InvalidAdminException, InvalidPasswordException {
		if(adminRepo.existsById(id)) {
			Admin userpresent=adminRepo.getById(id);
			
			if(Objects.nonNull(adminDto.getFirstname())&&adminDto.getFirstname()!=""){
				userpresent.setFirstName(adminDto.getFirstname());
			}
			if(Objects.nonNull(adminDto.getLastname())&&adminDto.getLastname()!=""){
				userpresent.setLastName(adminDto.getLastname());
			}
		
			if(Objects.nonNull(adminDto.getPassword())&&adminDto.getPassword()!=""){
				if(adminDto.getPassword().matches("^(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{8,20}$")) {
					userpresent.setPassword(adminDto.getPassword());
				}else {
					throw new InvalidPasswordException();
				}
				
			}
			
			return adminRepo.save(userpresent);
			
			}
			else {
				throw new InvalidAdminException();
			}

}


	@Override
	public List<Admin> findAll() {
		// TODO Auto-generated method stub
		
		return adminRepo.findAll();
	}
}
