package com.CustomFinderMethod.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CustomFinderMethod.model.User;
import com.CustomFinderMethod.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	//save user in database
	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	//getAllUsers
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	//getUserbyId
	public Optional<User> getUserById(long id){
		return userRepository.findById(id);
	
	}
	
	//findByCity
	public List<User> getUserByCityName(String city){
		return userRepository.findByCity(city);
	}
	
	//findBypass
	public List<User> getUserByPassword(String password){
		return userRepository.findByPassword(password);
	}
	
	
	//findByNameOrCity
	public List<User> getUserByNameOrCity(String name, String city){
		return userRepository.findByNameOrCity(name,city);
	}
	
}
