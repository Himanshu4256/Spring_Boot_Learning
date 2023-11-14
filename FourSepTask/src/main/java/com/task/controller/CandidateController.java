package com.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.repo.CandidateRepository;

@RestController
@RequestMapping("/salary")
public class CandidateController {

    @Autowired
    private CandidateRepository candidateRepository;
    
    @GetMapping("/test")
    public String test() {
    	return "runnnnn";
    }

    @GetMapping("/highest")
    public double getHightSalary() {
        return candidateRepository.findHighestSalary();
    }

    @GetMapping("/lowest")
    public double getLowestSalary() {
        return candidateRepository.findLowestSalary();
    }

    @GetMapping("/average")
    public double getAverageSalary() {
        return candidateRepository.findAverageSalary();
    }
    
    @GetMapping("averageAge")
    public double getAverageAge() {
    	return candidateRepository.findaverageAge();
    }
    
    @GetMapping("Sepbirthdays")
    public String getBirthday() {
		return candidateRepository.findBirthdate();
    }
}
