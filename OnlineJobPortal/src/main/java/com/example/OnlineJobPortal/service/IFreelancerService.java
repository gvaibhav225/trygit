package com.example.OnlineJobPortal.service;

import com.example.OnlineJobPortal.entity.Freelancer;

public interface IFreelancerService {
	public Freelancer save(Freelancer freelancer);
	public Freelancer findById(Long id);
	public Freelancer update(Freelancer freelancer);
}
