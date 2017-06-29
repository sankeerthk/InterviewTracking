package com.bofa.interview.persistence.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="CANDIDATE_DETAILS")
public class Candidate {
	
	private long candidateId;
	private String firstName;
	private String lastName;
	private String email;
	private Timestamp interviewTimeSlot;
	private String feedback;
	private byte[] resume;
	
	@Id
	@Column(name="CANDIDATE_ID")
	@GeneratedValue
	public long getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(long candidateId) {
		this.candidateId = candidateId;
	}
	@Column(name="FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Column(name="LAST_NAME")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Column(name="EMAIL")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="INTERVIEW_TIME_SLOT")
	public Timestamp getInterviewTimeSlot() {
		return interviewTimeSlot;
	}
	public void setInterviewTimeSlot(Timestamp interviewTimeSlot) {
		this.interviewTimeSlot = interviewTimeSlot;
	}
	@Column(name="FEEDBACK")
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	@Column(name="RESUME")
	@Lob
	public byte[] getResume() {
		return resume;
	}
	public void setResume(byte[] resume) {
		this.resume = resume;
	}

}
