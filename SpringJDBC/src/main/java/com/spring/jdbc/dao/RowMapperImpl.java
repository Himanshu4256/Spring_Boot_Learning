package com.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

public class RowMapperImpl implements RowMapper<Student> {

	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student  stu = new Student();
		stu.setId(rs.getInt(1));
		stu.setName(rs.getString(2));
		stu.setCity(rs.getString(3));
		
		return stu;
	}

	

}
