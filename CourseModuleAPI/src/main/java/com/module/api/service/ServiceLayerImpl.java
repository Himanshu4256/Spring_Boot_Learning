package com.module.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.module.api.entities.Course;

@Service
public class ServiceLayerImpl implements ServiceLayer{

// yha hmne Repository ka use ni kiya hai constructor k though data dala hai, Here No work of db.
	List<Course> list;
	
	public ServiceLayerImpl() {
		list = new ArrayList<>();
		list.add(new Course(145, "Java Course","this course provide java knowledge"));
		list.add(new Course(146, "Spring Boot", "Advance Java"));
		
	}
	@Override
	public List<Course> getCoursesDetails() {
		
		return list;
	}

	
	@Override
	public Course getCourse(long courseId) {
		Course c = null;
		for (Course course : list) {
			if(course.getId()==courseId) {
				c=course;
				break;
			}
		}
		
		return c;
	}
	
	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		list.add(course);		
		return course;
	}
	
	
	




		
}
