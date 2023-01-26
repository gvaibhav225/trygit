package com.example.OnlineJobPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.OnlineJobPortal.entity.Freelancer;
@Repository
public interface FreelancerRepository extends JpaRepository<Freelancer,Integer>{

}
