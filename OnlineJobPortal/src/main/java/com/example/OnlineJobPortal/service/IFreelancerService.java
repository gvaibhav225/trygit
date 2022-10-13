package com.example.OnlineJobPortal.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.example.OnlineJobPortal.Dto.FreelancerDto;
import com.example.OnlineJobPortal.Exception.FreelancerAlreadyExistsException;
import com.example.OnlineJobPortal.Exception.FreelancerDoesNotExistsException;
import com.example.OnlineJobPortal.Exception.InvalidPasswordException;
import com.example.OnlineJobPortal.entity.Freelancer;

public interface IFreelancerService {
	public Freelancer save(FreelancerDto freelancerdto) throws  FreelancerAlreadyExistsException;
	public Optional<Freelancer> findById(int id) throws FreelancerDoesNotExistsException;
	public Freelancer update(FreelancerDto freelancerdto, int id) throws FreelancerDoesNotExistsException, InvalidPasswordException;
	public List<Freelancer> findAll();
	public List<Freelancer> deletebyid(int id);

}


