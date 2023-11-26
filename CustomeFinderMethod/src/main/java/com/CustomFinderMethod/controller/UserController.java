package com.CustomFinderMethod.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CustomFinderMethod.model.User;
import com.CustomFinderMethod.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService; 
	
	@PostMapping("/addUser")
	public String addUser(@RequestBody User user) {
		
		userService.saveUser(user);
		return "saved User";
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers(){
	return userService.getAllUsers();
	}
	
	@GetMapping("/getUserById/{id}") // /{id} - this id will we store in parameter es method k by @PathVariable, & phir ye getUserById(id); ko call krega 
	public Optional<User> getUserbyId(@PathVariable int id){
		return userService.getUserById(id);
	}
	
	@GetMapping("/getUserByCityName/{city}")
	public List<User> getUserByCity(@PathVariable String city) {
		return userService.getUserByCityName(city);
	}
	
	@GetMapping("getUserByPassword/{password}")
	public List<User> getUserByPass(@PathVariable String password){
		return userService.getUserByPassword(password);
	}
	
	@GetMapping("getUserByNameOrCity")
	public List<User> getUserByCityOrName(@RequestParam String name, @RequestParam String city){
		return userService.getUserByNameOrCity(name,city);
	}
}
