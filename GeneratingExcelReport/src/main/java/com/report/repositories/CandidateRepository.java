package com.report.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.report.model.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Integer>{

}
