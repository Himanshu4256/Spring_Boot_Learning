package com.module.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.module.api.entities.Course;
import com.module.api.service.ServiceLayer;

@RestController
public class CourseController {
	
	@Autowired
	private ServiceLayer  servicelayer;
	
	
	
	@GetMapping("/home")
	public String home() {
		return "this is home page";
	}
	
	@GetMapping("/courses")
	public List<Course> getCourses(){
		return this.servicelayer.getCoursesDetails();
	}
	
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return this.servicelayer.getCourse(Long.parseLong(courseId));
	}
	
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course)  //@RequestBody - bcoz obj liya hai.
	{
		// TODO Auto-generated method stub
		return this.servicelayer.addCourse(course);
	}
	
}
