package com.report.controller;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.Resource;

import com.report.model.Candidate;
import com.report.services.CandidateService;
import com.report.services.ExcelService;

@RestController
@RequestMapping("/candidates")
public class CandidateController {
	
	@Autowired
	private CandidateService candidateService;
	
	@Autowired
	private ExcelService excelService;
	
	@GetMapping("/allData")
	public List<Candidate> findAll() {
		List<Candidate> listAll = candidateService.listAll();
		return listAll;	
	}
	
	//For Generating the Excel Report save the data on Candidate Entity and Hit this API on Browser it will automatically generate the Excel File
	@RequestMapping("/excel")
	public ResponseEntity<Resource> download() throws IOException { 
		String fileName = "candidates.xlsx";
		ByteArrayInputStream actualData = excelService.getActualData();
		InputStreamResource file = new InputStreamResource(actualData);
		ResponseEntity<Resource> body = ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName= "+fileName)
				.contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
				.body(file);
		return body;
		
	}

}
