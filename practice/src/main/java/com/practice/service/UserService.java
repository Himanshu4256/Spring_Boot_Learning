package com.practice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.UserRepo.UserRepo;
import com.practice.entities.User;

@Service
public class UserService {
	private UserRepo userRepo;

//	@Autowired
	public UserService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	public List<User> getAllUser() {
		List<User> list = (List<User>) this.userRepo.findAll();
		return list;
	}

	public User getUserById(long id) {
		User user = null;
		try {
			user = this.userRepo.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;

	}

	public User deleteUser(int id) {
		User UUser = userRepo.deleteById(id);
		return UUser;
	}
	
public User addUser(User b){
	User result =userRepo.save(b);
	return result;
}

public void updateUser(User user,long userId) {
	user.setId(userId);
	userRepo.save(user);
	}


}
