package com.example.OnlineJobPortal.service;

import com.example.OnlineJobPortal.entity.Recruiter;

public interface IRecruiterService {
	public Recruiter save(Recruiter recruiter);
	public Recruiter findById(long id);
	public Recruiter update(Recruiter recruiter);
}
