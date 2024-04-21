package com.report.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.report.model.Candidate;
import com.report.repositories.CandidateRepository;

@Service
public class CandidateService {
	
	 @Autowired
	 private CandidateRepository candidateRepository;
	     
//	 @Transactional
	  public List<Candidate> listAll() {
	       List<Candidate> findAll = candidateRepository.findAll();
	       return findAll;
	  }
}
