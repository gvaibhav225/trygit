package com.example.OnlineJobPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.OnlineJobPortal.entity.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {

}
