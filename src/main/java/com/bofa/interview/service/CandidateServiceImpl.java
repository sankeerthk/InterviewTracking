package com.bofa.interview.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.bofa.interview.persistence.dao.CandidateDao;
import com.bofa.interview.persistence.model.Candidate;

@Service("candidateService")
@Transactional
public class CandidateServiceImpl implements CandidateService {
	
	@Autowired
	private CandidateDao candidateDao;

	public Candidate addCandidate(String firstName, String lastName, String email, MultipartFile resume){
		Candidate candidate = new Candidate();
		candidate.setFirstName(firstName);
		candidate.setLastName(lastName);
		candidate.setEmail(email);
		try {
			byte[] bytes = resume.getBytes();
			candidate.setResume(bytes);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		candidateDao.save(candidate);
		return 	candidate;
	}

	public Candidate updateCandidate(Candidate candidate) {
		candidateDao.save(candidate);
		return candidate;
	}

	public List<Candidate> getAllCandidates() {
		return candidateDao.getAllCandidates();
	}

	public Candidate getCandidate(long id) {
		return candidateDao.getCandidate(id);
	}

	public Candidate addInterviewTimeSlot(long id, Timestamp interviewTimeSlot) {
		Candidate c= getCandidate(id);
		c.setInterviewTimeSlot(interviewTimeSlot);
		candidateDao.save(c);
		return c;
	}

	public Candidate addFeedback(long id, String feedback) {
		Candidate c= getCandidate(id);
		c.setFeedback(feedback);
		candidateDao.save(c);
		return c;
	}

	public boolean deleteCandidate(long id) {
		return candidateDao.delete(id);
	}

}
