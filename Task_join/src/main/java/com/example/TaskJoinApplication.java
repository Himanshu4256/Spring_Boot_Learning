package com.example;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.Repo.EmployeeRepository;
import com.example.entities.Employee;

@SpringBootApplication
public class TaskJoinApplication {

	public static void main(String[] args) {
	 SpringApplication.run(TaskJoinApplication.class, args);
	 
	 
//	 ApplicationContext context= SpringApplication.run(TaskJoinApplication.class, args);
//	EmployeeRepo emprepo=context.getBean(EmployeeRepo.class);
//	
//	List<Employee> allemp=emprepo.findAll();
//	allemp.forEach(e->{System.out.println(e);});
//	
//	
//	
//	System.out.println("_____________________________________");
//	emprepo.getEmployee().forEach(e->System.out.println(e));
//	
//	
	}

}
