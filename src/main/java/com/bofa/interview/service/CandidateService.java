package com.bofa.interview.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bofa.interview.persistence.model.Candidate;

public interface CandidateService {

	Candidate addCandidate(String firstName, String lastName, String email, MultipartFile resume);

	Candidate updateCandidate(Candidate candidate);

	List<Candidate> getAllCandidates();

	Candidate getCandidate(long id);

	Candidate addInterviewTimeSlot(long id, Timestamp interviewTimeSlot);

	Candidate addFeedback(long id, String feedback);

	boolean deleteCandidate(long id);

	

}
