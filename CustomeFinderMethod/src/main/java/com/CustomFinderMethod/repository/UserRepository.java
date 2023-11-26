package com.CustomFinderMethod.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.CustomFinderMethod.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public List<User> findByCity(String city);
	public List<User> findByPassword(String password);
	public List<User> findByNameOrCity(String name, String city);
	
}
