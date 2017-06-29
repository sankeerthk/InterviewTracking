package com.bofa.interview.persistence.dao;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bofa.interview.persistence.model.Candidate;

@Repository
@Transactional
public class CandidateDaoImpl extends AbstractDao<Long, Candidate> implements CandidateDao{

	private static final String HQL_FIND_ALL_CANDIDATES = "from Candidate";
	
	private static final String HQL_FIND_CANDIDATE_BY_ID = "from Candidate where candidateId = :candidateId";
	
	private static final String HQL_DELETE_CANDIDATE_BY_ID = "delete Candidate where candidateId = :candidateId";
	
	
	public void save(Candidate candidate) {
		saveOrUpdate(candidate);
	}

	public List<Candidate> getAllCandidates() {
		@SuppressWarnings("unchecked")
		List<Candidate> list = getSession().createQuery(HQL_FIND_ALL_CANDIDATES).getResultList();
		if (list == null) {
			list = Collections.emptyList();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public Candidate getCandidate(long id) {
		List<Candidate> list= getSession().createQuery(HQL_FIND_CANDIDATE_BY_ID).setParameter("candidateId", id).getResultList();
		if (list == null) {
			list = Collections.emptyList();
		}
		return list.get(0);
	}

	public boolean delete(long id) {
		int result = getSession().createQuery(HQL_DELETE_CANDIDATE_BY_ID).setParameter("candidateId", id).executeUpdate();
		if (result > 0) {
		    System.out.println("record removed");
		    return true;
		}
		return false;
	}

}
