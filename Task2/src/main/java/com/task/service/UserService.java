package com.task.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.Repo.UserRepo;
import com.task.entities.User;
@Service
public class UserService {
	@Autowired
	private UserRepo user;
	public User getUserById(Integer id) {
		
	Optional<User> result =user.findById(id); 
	return result.get();
}
}
