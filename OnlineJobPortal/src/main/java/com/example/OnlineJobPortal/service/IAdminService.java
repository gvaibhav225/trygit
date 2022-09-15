package com.example.OnlineJobPortal.service;

import com.example.OnlineJobPortal.entity.Admin;

public interface IAdminService {
	public Admin save(Admin admin);
	public Admin update(Admin admin);
	public Admin findById(long id);
}
