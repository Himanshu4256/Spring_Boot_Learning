package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Repo.EmployeeRepository;
import com.example.entities.Employee;

@Service
public class EmployeeService {
	 private EmployeeRepository employeeRepository;

	    @Autowired
	    public EmployeeService(EmployeeRepository employeeRepository) {
	        this.employeeRepository = employeeRepository;
	    }

	    public double getHighestSalary() {
	        return employeeRepository.findHighestSalary();
	    }

	    public double getLowestSalary() {
	        return employeeRepository.findLowestSalary();
	    }

	    public double getAverageSalary() {
	        return employeeRepository.findAverageSalary();
	    }
	    
	    //check average age of employee working
	    public Double getAverageAge() {
	        return employeeRepository.calculateAverageAge();
	        }
	    
	    //
	    public List<Employee> getEmployeesWithSeptemberBirthdays() {
	        return employeeRepository.findEmployeesWithSeptemberBirthdays();

}
	    }
