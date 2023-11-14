package com.module.api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Course {
	@Id
	private long id;
	private String title;
	private String description;
	
	public Course(int id, String title, String description) {
		// TODO Auto-generated constructor stub
		
		super();
		this.id = id;
		this.title = title;
		this.description = description;
	}
	
	
}
