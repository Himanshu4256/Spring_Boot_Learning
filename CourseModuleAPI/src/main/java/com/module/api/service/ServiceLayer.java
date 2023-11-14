package com.module.api.service;

import java.util.List;

import com.module.api.entities.Course;

// this is for loose coupling
public interface ServiceLayer {
	
	public List<Course> getCoursesDetails();
	public Course getCourse(long courseId);
	public Course addCourse(Course course);
	
}