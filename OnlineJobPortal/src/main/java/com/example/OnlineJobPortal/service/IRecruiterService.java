package com.example.OnlineJobPortal.service;

import java.util.List;
import java.util.Optional;

import com.example.OnlineJobPortal.Dto.RecruiterDto;
import com.example.OnlineJobPortal.Exception.FreelancerAlreadyExistsException;
import com.example.OnlineJobPortal.Exception.FreelancerDoesNotExistsException;
import com.example.OnlineJobPortal.Exception.InvalidPasswordException;
import com.example.OnlineJobPortal.entity.Recruiter;

public interface IRecruiterService {
	public Recruiter save(RecruiterDto recruiterdto) throws FreelancerAlreadyExistsException;
	public Optional<Recruiter> findById(int id) throws FreelancerDoesNotExistsException;
	public Recruiter update(RecruiterDto recruiterdto, int id) throws FreelancerDoesNotExistsException, InvalidPasswordException;
	public List<Recruiter> findAll();
	public List<Recruiter> deletebyid(int id);
}
