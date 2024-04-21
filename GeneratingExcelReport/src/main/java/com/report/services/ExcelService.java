package com.report.services;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.report.helper.Helper;
import com.report.model.Candidate;
import com.report.repositories.CandidateRepository;

@Service
public class ExcelService {
	
	@Autowired
	private CandidateRepository candidateRepository;
	
	public ByteArrayInputStream getActualData() throws IOException {
		
		List<Candidate> findAll = candidateRepository.findAll();
		ByteArrayInputStream byteArrayInputStream = Helper.dataToExcel(findAll);
		return byteArrayInputStream;
		
	}
	
}