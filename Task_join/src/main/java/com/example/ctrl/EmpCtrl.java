 package com.example.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Employee;
import com.example.service.EmployeeService;

@RestController
@RequestMapping("/organization")
public class EmpCtrl {
	
//	@RequestMapping("/test")
	@GetMapping("/test")
	public String test(){
		return "this for testing";
	}
// check highest salary , lowest salary and average salary
	    private final EmployeeService employeeService;

	    @Autowired
	    public EmpCtrl(EmployeeService employeeService) {
	        this.employeeService = employeeService;
	    }

	    @GetMapping("/highest-salary")
	    public double getHighestSalary() {
	        return employeeService.getHighestSalary();
	    }

	    @GetMapping("/lowest-salary")
	    public double getLowestSalary() {
	        return employeeService.getLowestSalary();
	    }

	    @GetMapping("/average-salary")
	    public double getAverageSalary() {
	        return employeeService.getAverageSalary();
	    }
	    
	    //check average age of employee working on controller
	    @GetMapping("/average-age")
	    public Double getAverageAge() {
	        return employeeService.getAverageAge();
	    }
	    
	    @GetMapping("/september-birthdays")
	    public List<Employee> getEmployeesWithSeptemberBirthdays() {
	        return employeeService.getEmployeesWithSeptemberBirthdays();
	    }

}
