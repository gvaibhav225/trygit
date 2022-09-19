package com.example.OnlineJobPortal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.OnlineJobPortal.Dto.BookmarkedJobDTO;
import com.example.OnlineJobPortal.Dto.BookmarkedJobListDTO;
import com.example.OnlineJobPortal.entity.BookmarkedJob;



@Service
public interface IBookmarkedJobService {

	BookmarkedJob bookmarkJob(BookmarkedJobDTO bjd);

	List<BookmarkedJob> findBookmarkedJobsBySkillName(String name);

	BookmarkedJob findById(Long id);
	
	List<BookmarkedJobListDTO> findAllBookmarks(Long frId);

	Long getCurrentId();
	
	void remove(Long BId);

}
