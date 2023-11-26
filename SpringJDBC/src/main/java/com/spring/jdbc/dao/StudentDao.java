package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.entities.Student;

public interface StudentDao {
	public int insert(Student student);
	public int update(Student student);
	public int delete(int studentId); //"studentId" ye wo perameter hai jo Hame Nikalna hai.
	public Student fetchStudent(int studentId);
	public List<Student> fetchAllStudent();
	
		 
}
