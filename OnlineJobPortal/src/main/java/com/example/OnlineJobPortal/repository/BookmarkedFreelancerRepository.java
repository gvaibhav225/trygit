package com.example.OnlineJobPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.OnlineJobPortal.entity.BookmarkedFreelancer;
@Repository
public interface BookmarkedFreelancerRepository extends JpaRepository<BookmarkedFreelancer,Integer> {

}
