package com.example.OnlineJobPortal.service;

import java.util.List;
import java.util.Optional;

import com.example.OnlineJobPortal.Dto.AdminDto;
import com.example.OnlineJobPortal.Exception.InvalidAdminException;
import com.example.OnlineJobPortal.Exception.InvalidPasswordException;
import com.example.OnlineJobPortal.entity.Admin;

public interface IAdminService {
	public Admin save(AdminDto adminDto) throws InvalidAdminException;
	public Admin update(AdminDto adminDto, int id) throws InvalidAdminException, InvalidPasswordException;
	public Optional<Admin> findById(int id) throws InvalidAdminException;
	public List<Admin> findAll();

}
