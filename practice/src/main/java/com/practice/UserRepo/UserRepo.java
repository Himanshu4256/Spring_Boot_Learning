package com.practice.UserRepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.entities.User;

public interface UserRepo extends JpaRepository<User,Long>{
	public User findById(long id);
	public User deleteById(long id);


}
