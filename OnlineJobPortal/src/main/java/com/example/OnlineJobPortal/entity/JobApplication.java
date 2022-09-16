package com.example.OnlineJobPortal.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;

@Entity
public class JobApplication {
	private long id;
	private Job job;
	private LocalDateTime appliedDate;
	private String coverLetter;
}
